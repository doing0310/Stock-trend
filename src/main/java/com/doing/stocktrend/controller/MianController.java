package com.doing.stocktrend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MianController {

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

    @GetMapping("/webSocket")
    public ModelAndView socket() {
        ModelAndView mav=new ModelAndView("/webSocket");
        return mav;
    }




}
