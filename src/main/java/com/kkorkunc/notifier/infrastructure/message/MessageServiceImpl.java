package com.kkorkunc.notifier.infrastructure.message;

import com.kkorkunc.notifier.domain.message.Message;
import com.kkorkunc.notifier.domain.message.MessageService;
import com.kkorkunc.notifier.domain.message.MessageStatus;
import com.kkorkunc.notifier.infrastructure.message.jpa.entity.MessageEntity;
import com.kkorkunc.notifier.infrastructure.message.jpa.repository.MessageJpaRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageServiceImpl implements MessageService {

    final MessageJpaRepository messageJpaRepository;

    @Override
    public List<Message> getReadyToSendMessages(int count) {
        return messageJpaRepository.getXMessageWithStatus(MessageEntity.Status.READY_TO_SEND, count)
                .stream()
                .map(MessageEntity::to)
                .collect(Collectors.toList());
    }

    @Override
    public List<Message> getAllByStatus(MessageStatus status) {
        return messageJpaRepository.findAllByStatus(MessageEntity.Status.from(status)).stream()
                .map(MessageEntity::to)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Message message) {
        messageJpaRepository.save(MessageEntity.from(message));
    }
}
