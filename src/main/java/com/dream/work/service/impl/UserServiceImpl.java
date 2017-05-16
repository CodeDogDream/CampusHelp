package com.dream.work.service.impl;

import com.dream.work.dao.UserDao;
import com.dream.work.entity.UserInfo;
import com.dream.work.exception.use.ChangeUserInfoException;
import com.dream.work.exception.use.UserException;
import com.dream.work.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Dream on 2017/3/5.
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public UserInfo getUserInfo(int uid) throws UserException {
        UserInfo userInfo = userDao.getUserInfo(uid);
        if (userInfo == null) {
            throw new UserException("获取用户信息失败");
        }
        return userInfo;
    }

    @Transactional
    public void changeUserInfo(int uid, String dataName, String data) throws ChangeUserInfoException, UserException {
        if ("uid".equals(dataName)) {
            throw new UserException("不能修改用户id");
        }
        int length = userDao.updateUserInfo(uid, dataName, data);
        if (length == 0) {
            throw new ChangeUserInfoException("用户不存在");
        } else if (length > 1) {
            throw new UserException("更改用户信息失败");
        }

    }

    @Transactional
    public void UpdateUserLocation(int uid, Double longitude, Double latitude) throws UserException {
            try {
                userDao.updateUserLocation(uid,longitude,latitude);
            }catch (Exception e){
                throw new UserException("更新位置信息失败");
            }
    }

    public void UpdateUserAvatar(int uid, String avatar) {
        try {
            userDao.updateUserAvatar(uid,avatar);
        }catch (Exception e){
            throw new UserException("更新头像失败");
        }
    }
}
