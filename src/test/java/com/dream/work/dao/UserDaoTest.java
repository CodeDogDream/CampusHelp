package com.dream.work.dao;

import com.dream.work.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Dream on 2017/3/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void getUserInfo() throws Exception {
        UserInfo userInfo = userDao.getUserInfo(1000);
        System.out.println(userInfo);
    }

    @Test
    public void updateUserInfo() throws Exception {
        int count = userDao.updateUserInfo(1000, "uname", "你好");
        System.out.println("count=" + count);
    }

    @Test
    public void insertUserInfo() throws Exception {
        UserInfo userInfo = new UserInfo(1005, "哈哈", 13913591969l, "哈哈哈", "/path/131.jpg", 20, "男", "苏州大学", "计算机",165.6,165.7);
        int count = userDao.insertUserInfo(userInfo);
        System.out.println("count=" + count);
    }

}