package com.dream.work.service;

import com.dream.work.entity.UserInfo;
import com.dream.work.exception.use.ChangeUserInfoException;
import com.dream.work.exception.use.UserException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 专门针对于和用户相关的交互
 * Created by Dream on 2017/3/4.
 */

public interface UserService {
    //获取用户信息
    UserInfo getUserInfo(int uid) throws UserException;

    //更改用户某个信息
    void changeUserInfo(int uid, String dataName, String data) throws ChangeUserInfoException, UserException;


}
