package com.kkorkunc.notifier.domain.message;

import java.util.List;

public interface MessageRepository {
    List<Message> getReadyToSendMessages();
    List<Message> getAll();
    void save();
}
