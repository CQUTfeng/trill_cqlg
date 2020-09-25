package com.qf.trillcqlg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/getAll")
    public void  getAll(){
        //这里可以获取到视频
    }
}
