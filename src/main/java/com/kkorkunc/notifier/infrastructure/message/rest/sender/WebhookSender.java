package com.kkorkunc.notifier.infrastructure.message.rest.sender;

import com.kkorkunc.notifier.domain.message.Message;
import com.kkorkunc.notifier.domain.message.sender.Sender;
import com.kkorkunc.notifier.domain.message.sender.exception.MessageCouldntSendException;
import com.kkorkunc.notifier.infrastructure.message.cache.ExternalStorage;
import com.kkorkunc.notifier.infrastructure.message.rest.commons.ClientGenerator;
import com.kkorkunc.notifier.infrastructure.message.rest.sender.client.WebhookClient;
import com.kkorkunc.notifier.infrastructure.message.rest.sender.client.model.WebhookContent;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WebhookSender implements Sender {
    private static final Logger LOG = LoggerFactory.getLogger(WebhookSender.class);

    @Value("${message.sender.webhook-client}")
    String clientUrl;

    WebhookClient webhookClient;

    @Autowired
    ExternalStorage externalStorage;

    @Override
    public void send(Message message) throws MessageCouldntSendException {
        try {
            var sendingTime = LocalDateTime.now();
            var result = getClient().send(WebhookContent.from(message.getRecipientPhoneNumber(), message.getContent())).execute().body();
            if (result == null || result.getMessage() == null || result.getMessageId().isBlank()) {
                throw new MessageCouldntSendException("Result or Message ID is not a part of the response, accepting as not sended");
            }

            externalStorage.storeMessageMetadata(sendingTime, result.getMessageId());
        } catch (IOException ioException) {
            LOG.error("Error while trying to send webhook", ioException);
            throw new MessageCouldntSendException("Exception occurred while trying to send webhook");
        }

    }

    private WebhookClient getClient() {
        if (webhookClient == null) {
            webhookClient = ClientGenerator.createService(WebhookClient.class, clientUrl);
        }
        return webhookClient;
    }
}
