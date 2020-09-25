package com.qf.trillcqlg.service;

import com.qf.trillcqlg.dto.Result;
import com.qf.trillcqlg.pojo.Video;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface VideoService {
    Result getAll(Integer page, Integer limit);

    Result selectByLike(String id, String videoDesc);

    Result deleteById(String[] ids);

    Result update(String id ,String field,String value);

    Video findVideoById(String id);

    Result up(MultipartFile file, HttpServletRequest request);


}
