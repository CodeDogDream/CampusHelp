package com.dream.work.exception.login;

/**
 * Created by Dream on 2017/3/5.
 */
public class LoginException extends RuntimeException {
    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
