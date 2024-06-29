package com.kkorkunc.notifier.infrastructure.message.rest;

import com.kkorkunc.notifier.application.GetMessagesCommandHandler;
import com.kkorkunc.notifier.infrastructure.message.rest.model.SentMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class MessageController {

    @Autowired
    GetMessagesCommandHandler getMessagesCommandHandler;

    // in case of a query parameter situation for status, change the base request mapping to api/v1/messages
    // and add status query param to new api.
    @GetMapping("sent-messages")
    public List<SentMessageResponse> getAllSentMessages() {
        return getMessagesCommandHandler.getSentMessages()
                .stream()
                .map(SentMessageResponse::from)
                .collect(Collectors.toList());
    }
}
