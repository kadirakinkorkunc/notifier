package com.kkorkunc.notifier.domain.message.exception;

public class MessageAlreadySentException extends RuntimeException {

    public MessageAlreadySentException(String message) {
        super(message);
    }
}
