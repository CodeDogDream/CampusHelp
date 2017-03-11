package com.dream.work.controller;

import com.dream.work.exception.login.GetCaptchaException;
import com.dream.work.exception.login.LoginException;
import com.dream.work.service.LoginService;
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
 * Created by Dream on 2017/3/5.
 */
@Controller
@ResponseBody
@RequestMapping(value = "/login", method = RequestMethod.POST)
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private JsonObject jsonObject;

    //从spring容器中取出bean
    @Resource
    private LoginService loginService;

    @RequestMapping(value = "/getCaptcha/{mobile}")
    public String getCaptcha(@PathVariable("mobile") long mobile) {
        jsonObject = new JsonObject();
        try {
            loginService.getCaptcha(mobile);
            jsonObject.addProperty("msg", "验证码发送成功");
            logger.debug("验证码发送成功");
            return ResponseUtils.getBasicResponse(jsonObject);
        } catch (GetCaptchaException e) {
            logger.debug("msg is" + e.getMessage());
            return ResponseUtils.getErrorResponseJson(e.getMessage());
        } catch (LoginException e) {
            logger.debug(" msg is" + e.getMessage());
            return ResponseUtils.getErrorResponseJson(e.getMessage());
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return ResponseUtils.getErrorResponseJson(e.getMessage());
        }
    }

    @RequestMapping(value = "/userLogin/{mobile}/{captcha}")
    public String userLogin(@PathVariable("mobile") long mobile, @PathVariable("captcha") String captcha) {
        jsonObject = new JsonObject();
        try {
            loginService.userLogin(mobile, captcha);
            jsonObject.addProperty("msg", "登录成功");
            logger.debug("登录成功");
            return ResponseUtils.getBasicResponse(jsonObject);
        } catch (LoginException e) {
            return ResponseUtils.getErrorResponseJson(e.getMessage());
        } catch (Exception e) {
            logger.error(e.toString());
            return ResponseUtils.getErrorResponseJson("登陆失败");
        }
    }
}
