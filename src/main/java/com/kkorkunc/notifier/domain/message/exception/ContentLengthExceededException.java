package com.kkorkunc.notifier.domain.message.exception;

public class ContentLengthExceededException extends RuntimeException {

    public ContentLengthExceededException(String maxContentLength) {
        super("Content length exceeded. Max content length is " + maxContentLength);
    }
}
