package com.dream.work.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Dream on 2017/3/3.
 */
public interface LoginDao {
    /***
     * 插入方法，给手机发送验证码,因为java的原因需要声明@Param来告诉mybatis属性名
     * @param mobile
     * @param captcha
     * @param send_time
     * @return
     */
    int sendCaptcha(@Param("mobile") long mobile, @Param("captcha") String captcha, @Param("send_time") long send_time, @Param("send_count") int send_count);

    /***
     * 验证用户登录获取获取uid
     * @param mobile
     * @param captcha
     * @return
     */
    String login(@Param("mobile") long mobile, @Param("captcha") String captcha);

    String isUser(long mobile);

    int updateCaptcha(@Param("mobile") long mobile, @Param("captcha") String captcha, @Param("send_time") long send_time, @Param("send_count") int send_count);

    long getSendTime(@Param("mobile") long mobile);
}
