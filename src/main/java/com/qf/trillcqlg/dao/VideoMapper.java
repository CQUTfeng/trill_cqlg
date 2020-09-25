package com.qf.trillcqlg.dao;

import com.qf.trillcqlg.dto.VideoDto;
import com.qf.trillcqlg.pojo.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Video record);

    Video selectByPrimaryKey(String id);

    int updateByPrimaryKey(Video record);
    List<Video>  getAll(Integer integer,String a);

    List<VideoDto> selectAll(@Param("page") Integer page, @Param("limit") Integer limit);

    List<VideoDto> selectByLike(@Param("id") String id,@Param("videoDesc") String videoDesc);

    Long countVideo();

    void update(@Param("id") String id ,@Param("field") String field,@Param("value") String value);
}