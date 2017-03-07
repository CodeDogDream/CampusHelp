package com.dream.work.exception.help;

/**
 * Created by Dream on 2017/3/4.
 */
public class GetHelpInfoException extends HelpException {
    public GetHelpInfoException() {
    }

    public GetHelpInfoException(String message) {
        super(message);
    }

    public GetHelpInfoException(String message, Throwable cause) {
        super(message, cause);
    }
}
