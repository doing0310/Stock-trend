package com.doing.stocktrend.controller;

import com.doing.stocktrend.bean.Stock;
import com.doing.stocktrend.page.TableDataInfo;
import com.doing.stocktrend.server.IMainService;
import com.doing.stocktrend.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MianController {

    @Autowired
    private IMainService iMainService;

    /**
     * 主页面
     */
    @GetMapping("/index")
    public String index()
    {
        return  "index";
    }

    /**
     * mian页面
     */
    @GetMapping("/main")
    public String main()
    {
        return  "main";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(String testing)
    {
        BaseUtils.startPage();
        List<Stock> list = iMainService.selectStockList(testing);
        return BaseUtils.getDataTable(list);
    }


}
