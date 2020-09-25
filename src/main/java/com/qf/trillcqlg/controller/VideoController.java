package com.qf.trillcqlg.controller;
//用户获取视频信息 http://localhost:8080/trillcqlg/videos/getAll

import com.qf.trillcqlg.dto.Result;
import com.qf.trillcqlg.pojo.Video;
import com.qf.trillcqlg.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @RequestMapping("/getAll")
    @ResponseBody
    public Result getAll(Integer page, Integer limit) {

         return  videoService.getAll(page, limit);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(String id ,String field,String value){
        // ctrl +shift+f9
        System.out.println("战胜恐惧的最好办法，就是面对恐惧，加油，坚持就是胜利，欧里给！");
        return videoService.update(id,field,value);
    }




    //因为开启了page=true     id   videosdesc   limit  page
    @RequestMapping("/selectByLike")
    @ResponseBody
    public Result videos(String id, String videoDesc) {
        return videoService.selectByLike(id, videoDesc);
    }



    @RequestMapping("/findVideoById")
    @ResponseBody
    public Video findVideoById(String id){
        return videoService.findVideoById(id);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(String[] ids){
        return videoService.deleteById(ids);
    }

    @RequestMapping("/addpath")
    public String addpath(){
        return "addvideo";
    }

    @RequestMapping("/up")
    @ResponseBody
    public Result up(MultipartFile file, HttpServletRequest request){
        return videoService.up(file,request);
    }





}
