package com.dream.work.service.impl;

import com.dream.work.dao.LoginDao;
import com.dream.work.dao.UserDao;
import com.dream.work.entity.UserInfo;
import com.dream.work.exception.login.GetCaptchaException;
import com.dream.work.exception.login.LoginException;
import com.dream.work.service.LoginService;
import com.dream.work.utils.PhoneFormatCheckUtils;
import com.dream.work.utils.ResponseUtils;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Random;

/**
 * Created by Dream on 2017/3/5.
 */

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginDao loginDao;
    @Resource
    private UserDao userDao;

    public String getCaptcha(long mobile) throws GetCaptchaException, LoginException {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        long now = System.currentTimeMillis() / 1000L;

        if (!PhoneFormatCheckUtils.isChinaPhoneLegal(String.valueOf(mobile))) {
            throw new GetCaptchaException("手机号码格式错误");
        }
        if (stringBuilder.length() == 0) {
            throw new GetCaptchaException("获取验证码失败");
        }
        if (StringUtils.isEmpty(loginDao.isUser(mobile))) {
            loginDao.sendCaptcha(mobile, stringBuilder.toString(), now, 0);
        } else {
            if (now - loginDao.getSendTime(mobile) < 60) {
                throw new GetCaptchaException("发送请求过于频繁");
            }
            loginDao.updateCaptcha(mobile, stringBuilder.toString(), now, 0);
        }

        return stringBuilder.toString();
    }

    @Transactional
    public String userLogin(long mobile, String captcha) throws LoginException {
        long now = System.currentTimeMillis() / 1000L;
        if (now - loginDao.getSendTime(mobile) < 300) {
            String uid = loginDao.login(mobile, captcha);
            if (StringUtils.isEmpty(uid)) {
                throw new LoginException("手机号或者验证码错误");
            } else {
                UserInfo userInfo = new UserInfo();
                userInfo.setUid(Integer.parseInt(uid));
                userInfo.setGender("男");
                userInfo.setMobile(mobile);
                userInfo.setUname("互助" + uid);
                userDao.insertUserInfo(userInfo);
                return uid;
            }
        } else {
            throw new LoginException("验证码已失效");
        }
    }
}
