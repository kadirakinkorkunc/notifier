package com.kkorkunc.notifier.domain.message.sender;

import com.kkorkunc.notifier.domain.message.Message;
import com.kkorkunc.notifier.domain.message.sender.exception.MessageCouldntSendException;

public interface Sender {

    void send(Message message) throws MessageCouldntSendException;
}
