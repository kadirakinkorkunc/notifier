package com.kkorkunc.notifier.application.dto;

import com.kkorkunc.notifier.domain.message.Message;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SentMessageDto {

    String recipientPhoneNumber;
    String content;

    public static SentMessageDto from(Message message) {
        return new SentMessageDto(message.getRecipientPhoneNumber(), message.getContent());
    }
}
