package com.dream.work.exception.help;

/**
 * 求助信息异常的统一管理
 * Created by Dream on 2017/3/4.
 */
public class HelpException extends RuntimeException {
    public HelpException() {
    }

    public HelpException(String message) {
        super(message);
    }

    public HelpException(String message, Throwable cause) {
        super(message, cause);
    }
}
