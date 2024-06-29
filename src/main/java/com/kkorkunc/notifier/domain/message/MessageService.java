package com.kkorkunc.notifier.domain.message;

import java.util.List;

public interface MessageService {
    List<Message> getReadyToSendMessages(int count);
    List<Message> getAll();
    void save(Message message);
}
