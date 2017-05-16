package com.dream.work.interceptor;

import com.dream.work.dao.TokenDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Dream on 2017/3/6.
 */
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class MyInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TokenDao tokenDao;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug(request.getRequestURI());
        if ("campus".equals(request.getHeader("accept-type"))) {
            if (!StringUtils.isEmpty(request.getHeader("token"))) {
                String token = request.getHeader("token");
                try {
                    long endTime = tokenDao.getEndTime(token);
                    long currentTime = System.currentTimeMillis() / 1000L;
                    if (currentTime > endTime) {
                        response.getWriter().write("{code:300}");
                        return false;
                    }
                } catch (Exception e) {
                    response.setStatus(403);
                    return false;
                }
            }
        } else {
            response.setStatus(403);
            return false;
        }
        logger.debug("preHandle");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("postHandle");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.debug("afterCompletion");
    }
}
