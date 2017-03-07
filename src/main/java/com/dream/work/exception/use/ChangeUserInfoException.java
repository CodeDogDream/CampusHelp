package com.dream.work.exception.use;

/**
 * Created by Dream on 2017/3/4.
 */
public class ChangeUserInfoException extends UserException {
    public ChangeUserInfoException() {
    }

    public ChangeUserInfoException(String message) {
        super(message);
    }

    public ChangeUserInfoException(String message, Throwable cause) {
        super(message, cause);
    }
}
