package com.kkorkunc.notifier.infrastructure.message.rest.sender.client.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class WebhookResult {

    String messageId;
    String message;
}
