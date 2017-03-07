package com.dream.work.exception.use;

/**
 * 用户信息异常的统一管理
 * Created by Dream on 2017/3/4.
 */
public class UserException extends RuntimeException {
    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
