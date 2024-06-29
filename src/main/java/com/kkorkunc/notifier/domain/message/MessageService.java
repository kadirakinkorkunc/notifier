package com.kkorkunc.notifier.domain.message;

import java.util.List;

public interface MessageService {
    List<Message> getReadyToSendMessages(int count);
    List<Message> getAllByStatus(MessageStatus status);
    void save(Message message);
}
