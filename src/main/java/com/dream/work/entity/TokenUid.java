package com.dream.work.entity;

/**
 * Created by Dream on 2017/3/5.
 */
public class TokenUid {
    private String token;
    private Long endTime;
    private Integer uid;


    @Override
    public String toString() {
        return "TokenUid{" +
                "token='" + token + '\'' +
                ", endTime=" + endTime +
                ", uid=" + uid +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
