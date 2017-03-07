package com.dream.work.exception.login;

/**
 * Created by Dream on 2017/3/5.
 */
public class GetCaptchaException  extends LoginException{
    public GetCaptchaException() {
    }

    public GetCaptchaException(String message) {
        super(message);
    }

    public GetCaptchaException(String message, Throwable cause) {
        super(message, cause);
    }
}
