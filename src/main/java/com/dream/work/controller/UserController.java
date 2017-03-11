package com.dream.work.controller;

import com.dream.work.entity.UserInfo;
import com.dream.work.exception.use.GetUserInfoException;
import com.dream.work.exception.use.UserException;
import com.dream.work.service.UserService;
import com.dream.work.utils.ResponseUtils;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Dream on 2017/3/7.
 */

@ResponseBody
@Controller
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private JsonObject jsonObject;

    @Resource(name = "UserService")
    private UserService userService;

    @RequestMapping(value = "getUserInfo/{uid}")
    public String getUserInfo(@PathVariable("uid") int uid) {
        try {
            UserInfo userInfo = userService.getUserInfo(uid);
            return ResponseUtils.getSuccessResponse(userInfo);
        } catch (GetUserInfoException e) {
            return ResponseUtils.getErrorResponseJson(e.getMessage());
        } catch (UserException e) {
            return ResponseUtils.getErrorResponseJson(e.getMessage());
        } catch (Exception e) {
            logger.warn(e.toString());
            return ResponseUtils.getErrorResponseJson("获取用户信息失败");
        }

    }

    @RequestMapping(value = "updateUserInfo/{uid}/{dataName}/{data}")
    public String updateUserInfo(@PathVariable("uid") int uid, @PathVariable("dataName") String dataName, @PathVariable("data") String data) {
        jsonObject = new JsonObject();
        try {
            userService.changeUserInfo(uid, dataName, data);
            jsonObject.addProperty("msg", "修改个人信息成功");
            return ResponseUtils.getBasicResponse(jsonObject);
        } catch (GetUserInfoException e) {
            logger.debug(e.getMessage());
            return ResponseUtils.getErrorResponseJson(e.getMessage());
        } catch (UserException e) {
            logger.debug(e.getMessage());
            return ResponseUtils.getErrorResponseJson(e.getMessage());
        } catch (Exception e) {
            logger.warn(e.toString());
            return ResponseUtils.getErrorResponseJson("修改个人信息失败");
        }
    }
}
