package com.dream.work.service;

import com.dream.work.entity.HelpInfo;
import com.dream.work.exception.help.ChangeHelpInfoException;
import com.dream.work.exception.help.GetHelpInfoException;
import com.dream.work.exception.help.HelpException;
import com.dream.work.exception.help.PostHelpInfoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 针对于求助信息的获取
 * Created by Dream on 2017/3/4.
 */

public interface HelpService {

    //发布求助信息
    int insertHelpInfo(HelpInfo helpInfo) throws PostHelpInfoException, HelpException;

    //修改求助信息
    int updateHelpInfo(Integer info_id, int uid, String dataName, String data) throws ChangeHelpInfoException, HelpException;

    //获取求助信息
    List<HelpInfo> getAllHelpInfo() throws GetHelpInfoException, HelpException;

    //根据tag获取求助信息
    List<HelpInfo> getHelpInfoByTag(String tag) throws GetHelpInfoException, HelpException;
}
