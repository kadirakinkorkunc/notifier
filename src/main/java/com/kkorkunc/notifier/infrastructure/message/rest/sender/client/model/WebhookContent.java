package com.kkorkunc.notifier.infrastructure.message.rest.sender.client.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class WebhookContent {

    String to;
    String content;

    public static WebhookContent from(String to, String message) {
        return new WebhookContent(to, message);
    }
}
