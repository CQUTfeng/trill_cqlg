package com.qf.trillcqlg.service.serviceImpl;

import com.qf.trillcqlg.dao.VideoMapper;
import com.qf.trillcqlg.dto.Result;
import com.qf.trillcqlg.dto.VideoDto;
import com.qf.trillcqlg.pojo.Video;
import com.qf.trillcqlg.service.VideoService;
import com.qf.trillcqlg.util.UpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public Result getAll(Integer page, Integer limit) {
        if(page !=null){
            page = (page-1)*limit;
        }else{
            page=0;
        }
        List<VideoDto> videos = videoMapper.selectAll(page,limit);
        Long total = videoMapper.countVideo();
        Result result = new Result();
        result.setData(videos);
        result.setTotal(total);
        return result;
    }

    @Override
    public Result selectByLike(String id, String videoDesc) {
        List<VideoDto> videos = videoMapper.selectByLike(id, videoDesc);
        Result result = new Result();
        result.setData(videos);
        return result;

    }

    @Override
    @Transactional
    public Result deleteById(String[] ids) {
        Result result = new Result();
         try {
             for (String id : ids) {
                 videoMapper.deleteByPrimaryKey(id);
             }
             return result;
         }catch (Exception e){
             e.printStackTrace();
             //设置手动回滚
             TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
             result.setMessage("error");
             return result;
         }
    }

    @Override
    @Transactional
    public Result update(String id ,String field,String value) {
        Result result = new Result();
        if("like_counts".equals(field)){
            if(!value.matches("^[0-9]*$")){
            result.setMessage("请合法输入！");
            return result;
            }
        }
        //先去通过修改对象的id去查找对应的数据是否存在
        Video video = videoMapper.selectByPrimaryKey(id);
        //判断当字段为点赞量的时候---去判断参数是否位数字，并且如果为数字的话，判断其大小（9999）
        //1. 使用正则表达式    2. 使用字符的判断方式
        if(video == null){
            result.setStatus(500);
            result.setMessage("请刷新页面后在尝试");
        }else{
            try {
                videoMapper.update(id,field,value);
            }catch (Exception e){
                e.printStackTrace();
                result.setMessage("系统繁忙，请稍侯再试");
                result.setStatus(501);
            }
        }
//        videoMapper.updateByPrimaryKey();
        return result;

    }

    @Override
    public Video findVideoById(String id) {
        return videoMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result up(MultipartFile file, HttpServletRequest request) {
        Result result = new Result();
        String msg = UpUtils.upfile(file, request);
        if(msg.equals("200")){
            result.setMessage(file.getOriginalFilename());
            return result;
        }
        result.setStatus(501);
        result.setMessage("上传异常");
        return result;
    }
}
