package com.dream.work.controller;

import com.dream.work.entity.HelpInfo;
import com.dream.work.exception.help.ChangeHelpInfoException;
import com.dream.work.exception.help.GetHelpInfoException;
import com.dream.work.exception.help.HelpException;
import com.dream.work.exception.help.PostHelpInfoException;
import com.dream.work.service.HelpService;
import com.dream.work.utils.ResponseUtils;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Dream on 2017/3/7.
 */
@Controller
@ResponseBody
@RequestMapping(value = "/help", method = RequestMethod.GET)
public class HelpController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource(name = "HelpService")
    private HelpService helpService;

    private JsonObject jsonObject;

    @RequestMapping("/publishHelp/{uid}/{uname}/{title}/{content}/{date}/{longitude}/{latitude}/{tag}")
    public String publishHelp(
            @PathVariable("uid") int uid,
            @PathVariable("uname") String uname,
            @PathVariable("title") String title,
            @PathVariable("content") String content,
            @PathVariable("date") Long date,
            @PathVariable("longitude") Double longitude,
            @PathVariable("latitude") Double latitude,
            @PathVariable("tag") String tag
    ) {
        jsonObject = new JsonObject();
        if (StringUtils.isEmpty(title)) {
            return ResponseUtils.getErrorResponseJson("标题不能为空");
        }
        if (StringUtils.isEmpty(content)) {
            return ResponseUtils.getErrorResponseJson("内容不能为空");
        }
        if (StringUtils.isEmpty(tag)) {
            return ResponseUtils.getErrorResponseJson("信息分类不能为空");
        }
        HelpInfo helpInfo = new HelpInfo();
        helpInfo.setUid(uid);
        helpInfo.setTitle(title);
        helpInfo.setUname(uname);
        helpInfo.setDate(date);
        helpInfo.setLatitude(latitude);
        helpInfo.setLongitude(longitude);
        helpInfo.setContent(content);
        helpInfo.setTag(tag);
        try {
            helpService.insertHelpInfo(helpInfo);
        } catch (PostHelpInfoException e) {
            return ResponseUtils.getErrorResponseJson(e.getMessage());
        } catch (HelpException e) {
            return ResponseUtils.getErrorResponseJson(e.getMessage());
        } catch (Exception e) {
            logger.equals(e.toString());
            return ResponseUtils.getErrorResponseJson("发布求助信息失败");
        }
        jsonObject.addProperty("msg", "发布成功");
        return ResponseUtils.getBasicResponse(jsonObject);
    }

    @RequestMapping("/changeHelpInfo/{info_id}/{uid}/{dataName}/{data}")
    public String changeHelpInfo(@PathVariable("info_id") int infoId,
                                 @PathVariable("uid") int uid,
                                 @PathVariable("dataName") String dataName,
                                 @PathVariable("data") String data) {
        jsonObject = new JsonObject();
        try {
            helpService.updateHelpInfo(infoId, uid, dataName, data);
        } catch (ChangeHelpInfoException e) {
            return ResponseUtils.getErrorResponseJson(e.getMessage());
        } catch (HelpException e) {
            return ResponseUtils.getErrorResponseJson(e.getMessage());
        } catch (Exception e) {
            logger.equals(e.toString());
            return ResponseUtils.getErrorResponseJson("修改求助信息失败");
        }
        jsonObject.addProperty("msg", "修改成功");
        return ResponseUtils.getBasicResponse(jsonObject);
    }

    @RequestMapping("/getAllHelpInfo")
    public String getAllHelpInfo() {
        try {
            return ResponseUtils.getSuccessResponse(helpService.getAllHelpInfo());
        } catch (GetHelpInfoException e) {
            return ResponseUtils.getErrorResponseJson("获取求助信息失败");
        } catch (Exception e) {
            return ResponseUtils.getErrorResponseJson("获取求助信息失败");
        }
    }

    @RequestMapping("/getTagHelpInfo/{tag}")
    public String getHelpInfoByTag(@PathVariable("tag") String tag) {
        try {
            List<HelpInfo> helpInfos = helpService.getHelpInfoByTag(tag);
            return ResponseUtils.getSuccessResponse(helpInfos);
        } catch (GetHelpInfoException e) {
            return ResponseUtils.getErrorResponseJson("获取求助信息失败");
        } catch (Exception e) {
            return ResponseUtils.getErrorResponseJson("获取求助信息失败");
        }
    }
}
