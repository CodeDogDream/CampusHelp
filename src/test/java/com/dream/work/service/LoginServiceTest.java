package com.dream.work.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Dream on 2017/3/5.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class LoginServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "LoginService")
    private LoginService service;

    @Test
    public void getCaptcha() throws Exception {
        String captcha = service.getCaptcha(13861333906l);
        System.out.println(captcha);
    }

    @Test
    public void userLogin() throws Exception {
        long mobile = 13913591970l;
        String captcha = "123456";
        System.out.print(service.userLogin(mobile, captcha));
    }

}