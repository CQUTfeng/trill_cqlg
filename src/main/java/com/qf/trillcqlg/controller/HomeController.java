package com.qf.trillcqlg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping("/main")
    public String main(){
        return "index";
    }

    @RequestMapping("/main1")
    public String main1(){
        return "main";
    }

    @RequestMapping("/videoinfo")
    public String videoinfo(){
        return "videoinfo";
    }
}
