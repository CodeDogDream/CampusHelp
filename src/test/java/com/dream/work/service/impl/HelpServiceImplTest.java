package com.dream.work.service.impl;

import com.dream.work.entity.HelpInfo;
import com.dream.work.service.HelpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dream on 2017/3/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class HelpServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private HelpService helpService;

    @Test
    public void insertHelpInfo() throws Exception {
        HelpInfo helpInfo = new HelpInfo();
        helpInfo.setUname("哈哈1");
        helpInfo.setTitle("求助标题");
        helpInfo.setContent("求助内容");
        helpInfo.setTag("这是求助类型");
        logger.debug(helpService.insertHelpInfo(helpInfo) + "");
    }

    @Test
    public void updateHelpInfo() throws Exception {

    }

    @Test
    public void getAllHelpInfo() throws Exception {
        List<HelpInfo> helpInfos = helpService.getAllHelpInfo();
        for (HelpInfo info :
                helpInfos) {
            logger.debug(info.toString());
        }
    }

    @Test
    public void getHelpInfoByTag() throws Exception {
        List<HelpInfo> helpInfos = helpService.getHelpInfoByTag("计机");
        for (HelpInfo info : helpInfos) {
            logger.debug(info.toString());
        }
    }

}