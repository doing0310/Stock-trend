package com.doing.stocktrend.controller;

import com.doing.stocktrend.bean.Stock;
import com.doing.stocktrend.config.ServerConfig;
import com.doing.stocktrend.page.TableDataInfo;
import com.doing.stocktrend.server.IMainService;
import com.doing.stocktrend.utils.pageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MianController {

    @Autowired
    private IMainService iMainService;

    /**
     * 主页面
     */
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        return  "index";
    }

    /**
     * mian页面
     */
    @GetMapping("/main")
    public String main(ModelMap mmap)
    {
        String url = ServerConfig.getUrl();
        mmap.put("url", url);
        return  "main";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(String testing)
    {
        pageUtils pageUtils=new pageUtils();
        pageUtils.startPage();
        List<Stock> list = iMainService.selectStockList(testing);
        return pageUtils.getDataTable(list);
    }


}
