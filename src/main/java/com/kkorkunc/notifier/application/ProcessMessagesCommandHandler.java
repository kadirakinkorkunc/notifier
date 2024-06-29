package com.kkorkunc.notifier.application;

import com.kkorkunc.notifier.domain.message.Message;
import com.kkorkunc.notifier.domain.message.MessageService;
import com.kkorkunc.notifier.domain.message.sender.Sender;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProcessMessagesCommandHandler {

    MessageService messageService;

    Sender sender;

    public void handle(Integer messageCountToProcess) {
        messageService.getReadyToSendMessages(messageCountToProcess).forEach(this::handle);
    }

    private void handle(Message message) {
        message.send(sender);
        message.markAsSent();
        messageService.save(message);
    }
}
