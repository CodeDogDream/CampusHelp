package com.dream.work.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;


/**
 * Created by Dream on 2017/3/6.
 */
public class MyInterceptor implements WebRequestInterceptor {

    public void preHandle(WebRequest request) throws Exception {

    }

    public void postHandle(WebRequest request, ModelMap model) throws Exception {

    }

    public void afterCompletion(WebRequest request, Exception ex) throws Exception {

    }
}
