package com.dream.work.dao;

import org.apache.ibatis.annotations.Param;

/**
 * token和用户关联查询
 * Created by Dream on 2017/3/5.
 */
public interface TokenDao {
    int insertToken(@Param("token") String token, @Param("endTime") Long endTime, @Param("uid") int uid);

    long getEndTime(String token);

    int getUid(String token);
}
