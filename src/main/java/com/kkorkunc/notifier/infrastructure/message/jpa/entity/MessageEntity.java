package com.kkorkunc.notifier.infrastructure.message.jpa.entity;

import com.kkorkunc.notifier.domain.message.Message;
import com.kkorkunc.notifier.domain.message.MessageStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity(name = "message")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class MessageEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Column(name = "recipient_phone_number")
    String recipientPhoneNumber;

    @Enumerated(value = EnumType.STRING)
    Status status;

    @Column(length = 500)
    String content;

    public enum Status {
        READY_TO_SEND,
        SENT;

        public MessageStatus to() {
            return switch (this) {
                case READY_TO_SEND -> MessageStatus.READY_TO_SEND;
                case SENT -> MessageStatus.SENT;
            };
        }

        public static Status from(MessageStatus status) {
            return switch (status) {
                case MessageStatus.READY_TO_SEND -> READY_TO_SEND;
                case MessageStatus.SENT -> SENT;
            };
        }
    }

    public Message to() {
        return new Message(id, recipientPhoneNumber, content, status.to());
    }

    public static MessageEntity from(Message message) {
        return new MessageEntity(message.getId(), message.getRecipientPhoneNumber(), Status.from(message.getStatus()), message.getContent());
    }
}
