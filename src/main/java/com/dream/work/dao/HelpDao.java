package com.dream.work.dao;

import com.dream.work.entity.HelpInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Dream on 2017/3/3.
 */
public interface HelpDao {

    List<HelpInfo> getAllHelpInfo();

    List<HelpInfo> getHelpInfoByTag(String tag);

    List<HelpInfo> getHelpInfoById(int uid);

    int insertHelpInfo(HelpInfo helpInfo);

    int updateHelpInfo(@Param("info_id") Integer info_id, @Param("uid") Integer uid, @Param("dataName") String dataName, @Param("data") String data);
}
