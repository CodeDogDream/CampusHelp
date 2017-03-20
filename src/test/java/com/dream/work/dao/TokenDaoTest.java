package com.dream.work.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Dream on 2017/3/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TokenDaoTest {
    @Resource
    private TokenDao tokenDao;

    @Test
    public void insertToken() throws Exception {
        String token = "dasdasfwe1hjgjh8";
        long now = System.currentTimeMillis() / 1000L;
        long end_time = now + 604800;
        int uid = 1000;
        int count = tokenDao.insertToken(token, end_time, uid);
        System.out.println("count=" + count);
    }

    @Test
    public void getEndTime() throws Exception {
        String token = "dasdasfwe1241288";
        long endTime = tokenDao.getEndTime(token);
        System.out.println(endTime);
    }

    @Test
    public void getUid() throws Exception {
        String token = "dasdasfwe1241278";
        int uid = tokenDao.getUid(token);
        System.out.println(uid);
    }

}