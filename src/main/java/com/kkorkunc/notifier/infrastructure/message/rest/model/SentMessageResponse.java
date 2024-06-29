package com.kkorkunc.notifier.infrastructure.message.rest.model;

import com.kkorkunc.notifier.application.dto.SentMessageDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class SentMessageResponse {

    String recipientPhoneNumber;
    String content;

    public static SentMessageResponse from(SentMessageDto messageDto) {
        return new SentMessageResponse(messageDto.getRecipientPhoneNumber(), messageDto.getContent());
    }
}
