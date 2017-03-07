package com.dream.work.service.impl;

import com.dream.work.dao.HelpDao;
import com.dream.work.entity.HelpInfo;
import com.dream.work.exception.help.ChangeHelpInfoException;
import com.dream.work.exception.help.GetHelpInfoException;
import com.dream.work.exception.help.HelpException;
import com.dream.work.exception.help.PostHelpInfoException;
import com.dream.work.service.HelpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Dream on 2017/3/7.
 */
@Service("HelpService")
public class HelpServiceImpl implements HelpService {
    @Resource
    private HelpDao helpDao;

    @Transactional
    public int insertHelpInfo(HelpInfo helpInfo) throws HelpException {
        int count = 0;
        try {
            count = helpDao.insertHelpInfo(helpInfo);
        } catch (Exception e) {
            throw new HelpException(e.toString());
        }
        if (count == 0) {
            throw new PostHelpInfoException("插入失败");
        }
        return count;
    }

    @Transactional
    public int updateHelpInfo(Integer info_id, int uid, String dataName, String data) throws HelpException {
        int count = 0;
        count = helpDao.updateHelpInfo(info_id, uid, dataName, data);
        if (count == 0) {
            throw new ChangeHelpInfoException("更新数据失败");
        }
        return count;
    }

    public List<HelpInfo> getAllHelpInfo() throws HelpException {
        try {
            List<HelpInfo> info = helpDao.getAllHelpInfo();
            return info;
        } catch (Exception e) {
            throw new GetHelpInfoException(e.toString());
        }
    }

    public List<HelpInfo> getHelpInfoByTag(String tag) throws HelpException {
        try {
            List<HelpInfo> info = helpDao.getHelpInfoByTag(tag);
            return info;
        } catch (Exception e) {
            throw new GetHelpInfoException(e.toString());
        }
    }
}
