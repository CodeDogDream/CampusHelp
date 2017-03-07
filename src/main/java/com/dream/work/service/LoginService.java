package com.dream.work.service;

import com.dream.work.exception.login.GetCaptchaException;
import com.dream.work.exception.login.LoginException;
import org.springframework.stereotype.Service;

/**
 * Created by Dream on 2017/3/5.
 */


public interface LoginService {
    //获取验证码
    String getCaptcha(long mobile) throws GetCaptchaException, LoginException;

    //用户登录
    String userLogin(long mobile, String captcha) throws LoginException;
}
