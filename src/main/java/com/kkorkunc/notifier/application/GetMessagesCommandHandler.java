package com.kkorkunc.notifier.application;

import com.kkorkunc.notifier.application.dto.SentMessageDto;
import com.kkorkunc.notifier.domain.message.MessageService;
import com.kkorkunc.notifier.domain.message.MessageStatus;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetMessagesCommandHandler {

    MessageService messageService;

    public List<SentMessageDto> getSentMessages() {
        return messageService.getAllByStatus(MessageStatus.SENT)
                .stream()
                .map(SentMessageDto::from)
                .collect(Collectors.toList());
    }
}
