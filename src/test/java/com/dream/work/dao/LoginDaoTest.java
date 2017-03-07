package com.dream.work.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * spring整合junit测试，配置spring的context位置
 * Created by Administrator on 2017/3/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class LoginDaoTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //将这个实体从spring中取出
    @Resource
    private LoginDao loginDao;

    @Test
    public void sendCaptcha() throws Exception {
        long mobile = 13913591969l;
        int captcha = 123456;
        long send_time = System.currentTimeMillis() / 1000L;
        int send_count = 1;
        int count = loginDao.sendCaptcha(13913591969l, "123456", send_time, send_count);
        System.out.println("count=" + count);
    }

    @Test
    public void login() throws Exception {
        long mobile = 13913591969l;
        String captcha = "123456";
        String uid = loginDao.login(mobile, captcha);
        System.out.println(uid);
    }

    @Test
    public void isUser() throws Exception {
        long mobile = 13913591968l;
        logger.debug(loginDao.isUser(mobile));
    }

    @Test
    public void updateInfo() throws Exception {
        long mobile = 13913591969l;
        int captcha = 123456;
        long send_time = System.currentTimeMillis() / 1000L;
        int send_count = 1;
        int count = loginDao.updateCaptcha(13913591969l, "199456", send_time, send_count);
        System.out.println("count=" + count);
    }

    @Test
    public void getSendTime() throws Exception {
        System.out.println(loginDao.getSendTime(13913591969l));
    }

}