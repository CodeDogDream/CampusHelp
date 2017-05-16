package com.dream.work.dao;

import com.dream.work.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Dream on 2017/3/3.
 */
public interface UserDao {
    UserInfo getUserInfo(int uid);

    int updateUserInfo(@Param("uid") int uid, @Param("dataName") String dataName, @Param("data") String data);

    int insertUserInfo(UserInfo userInfo);

    int updateUserLocation(@Param("uid") int uid, @Param("longitude") Double longitude, @Param("latitude") Double latitude);

    int updateUserAvatar(@Param("uid") int uid, @Param("avatar") String avatar);

    String getAvatarById(@Param("uid") int uid);
}
