package com.qf.trillcqlg.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VideoDto {
    private String id;
    private String nickname;
    private String video_path;
    private String video_desc;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date create_time;
    private Integer status;
    private Integer like_counts;

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLike_counts() {
        return like_counts;
    }

    public void setLike_counts(Integer like_counts) {
        this.like_counts = like_counts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getVideo_path() {
        return video_path;
    }

    public void setVideo_path(String video_path) {
        this.video_path = video_path;
    }

    public String getVideo_desc() {
        return video_desc;
    }

    public void setVideo_desc(String video_desc) {
        this.video_desc = video_desc;
    }
}
