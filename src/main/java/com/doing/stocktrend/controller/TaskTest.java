package com.doing.stocktrend.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.doing.stocktrend.bean.Stock;
import com.doing.stocktrend.bean.Stock2;
import com.doing.stocktrend.server.IMainService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class TaskTest {
    private final Logger log = LoggerFactory.getLogger(TaskTest.class);
    //输出时间格式
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:sss");

    @Autowired
    private IMainService iMainService;

    //晚上定时跑批
 /*   @Scheduled(cron = "0 53 0 * * ? ")//每20秒跑一次0 15 10 * * ? *”
    private void nightRun(){

        //清空表
        iMainService.deleteStock();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String day = formatter.format(date);
        System.out.println(formatter.format(date));
        day = quryTime(day,0);
        //查找数据
        quryNet(day);
    }*/

    //下午定时跑批
    @Scheduled(cron = "0 0/5 13-14 * * ?")//13点到15.55点每隔5分钟执行一次
    private void afternoonRun(){
        //清空表
        iMainService.deleteStock2();

        //查找数据
        quryNet2();
    }

    //上午定时跑批
    //@Scheduled(cron = "0 0/5 9-11 * * ?")//9点到11.55点每隔5分钟执行一次
    @Scheduled(cron = "0 58 20 * * ? ")
    private void morningRun(){
        //清空表
        iMainService.deleteStock2();

        //查找数据
        quryNet2();
    }


    //查詢時間
    public String quryTime(String date, int day){

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date time= null;
        try {
            time= formatter.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance(); //创建Calendar 的实例
        calendar.setTime(time);
        calendar.add(Calendar.DAY_OF_MONTH,day); //当前时间减去一天，即一天前的时间
        calendar.getTimeInMillis();//返回当前时间的毫秒数
        String date1 = formatter.format(calendar.getTime());
        System.out.println(date1);
        return formatter.format(calendar.getTime());
    }
    //查询页面财富通的股票数据，如果没有数据减一天
    public void quryNet(String day){
        String url="http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?" +
                "type=HSGT20_GGTJ_SUM" +
                "&token=894050c76af8597a853f5b408b759f5d" +
                "&st=ShareSZ_Chg_One" +
                "&sr=-1" +
                "&p=1" +
                "&ps=10000" +
                "&js=var%20IpfNAnKN={pages:(tp),data:(x)}" +
                "&filter=(DateType=%271%27%20and%20HdDate=%27" +
                day +
                "%27)" +
                "&rt=52909213";

        try {
            //获取页面源代码
            Document document = Jsoup.connect(url)
                    .timeout(10000)
                    .ignoreContentType(true)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                    .get();
            //获得页面的文字
            String txt = document.text();
            String[] strArr = txt.split("=");
            txt = strArr[1];
            //获取股票的信息转为json
            JSONObject jsonObject = JSONObject.parseObject(txt);
            Map<String,Object> map = (Map<String,Object>)jsonObject;
            JSONArray jsonArray = (JSONArray) map.get("data");
            System.out.println(jsonArray);
            if(jsonArray.isEmpty()){
                quryNet(quryTime(day,-1));
                return;
            }
            //股票的信息json转为list
            List<Stock> stockList = JSONObject.parseArray(jsonArray.toJSONString(), Stock.class);

            for (Stock stock:stockList){
                //插入数据库中
                System.out.println(stock.toString());
                iMainService.insertStock(stock);
            }

            System.out.println("结束");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //查询手机端同花顺的股票数据，如果没有数据减一天
    public void quryNet2(){
        int i=1;
        quiryNewDate(i);

    }
    //查询当天的数据
    public void quiryNewDate(int i){
        try {
            String url="http://eq.10jqka.com.cn/hshkData/index.php?" +
                    "op=getData" +
                    "&marketType=1" +
                    "&sortType=desc" +
                    "&sortBy=shareHolding" +
                    "&pageNum="+i;


            //获取页面源代码
            Document document = Jsoup.connect(url)
                    .timeout(10000)
                    .ignoreContentType(true)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                    .get();
            //获得页面的文字
            String txt = document.text();
            //System.out.println(txt);
            //获取股票的信息转为json
            String jsonObject = JSONObject.parseObject(txt).getString("data");
            //System.out.println(jsonObject);
            JSONObject json = JSONObject.parseObject(jsonObject);
            Map<String,Object> map = (Map<String,Object>)json;
            //取其中的list集合
            JSONArray jsonArray = (JSONArray) map.get("list");
            //System.out.println(jsonArray);
            List<Stock2> stock2List = JSON.parseArray(jsonArray.toJSONString(), Stock2.class);
            for (Stock2 stock:stock2List){
                //插入数据库中
                System.out.println(stock.toString());
                iMainService.insertStock2(stock);
            }
            if(!stock2List.isEmpty()){
                i++;
                System.err.println(i);
                quiryNewDate(i);
            }else {
                System.out.println("结束");
                return;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}