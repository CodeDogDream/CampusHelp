package com.dream.work.dao;

import com.dream.work.entity.HelpInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dream on 2017/3/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class HelpDaoTest {

    @Resource
    private HelpDao helpDao;

    @Test
    public void getAllHelpInfo() throws Exception {
        List<HelpInfo> helpInfos = helpDao.getAllHelpInfo();
        for (HelpInfo info :
                helpInfos) {
            System.out.println(info);
        }
    }

    @Test
    public void getHelpInfoByTag() throws Exception {
        String tag = "数学";
        List<HelpInfo> helpInfos = helpDao.getHelpInfoByTag(tag);
        for (HelpInfo info :
                helpInfos) {
            System.out.println(info);
        }
    }

    @Test
    public void insertHelpInfo() throws Exception {
        long time = System.currentTimeMillis() / 1000L;
        HelpInfo helpInfo = new HelpInfo(1000, 1004, "哈哈", "哈哈哈哈", "哈哈哈哈哈还", time, 165.6, 153.4, "计算机");
        int count = helpDao.insertHelpInfo(helpInfo);
        System.out.println("count=" + count);
    }

    @Test
    public void updateHelpInfo() throws Exception {
        String dataName = "tag";
        String data = "数学";
        int count = helpDao.updateHelpInfo(1000, 1000, dataName, data);
        System.out.println("count=" + count);
    }

}