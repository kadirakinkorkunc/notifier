package com.kkorkunc.notifier.domain.message.sender.exception;

public class MessageCouldntSendException extends RuntimeException {

    public MessageCouldntSendException(String message) {
        super(message);
    }
}
