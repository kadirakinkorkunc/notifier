package com.kkorkunc.notifier.infrastructure.message.job;

import com.kkorkunc.notifier.application.ProcessMessagesCommandHandler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageProcessJob {

    @Autowired
    ProcessMessagesCommandHandler handler;

    @Value("${message.count-to-process-at-once:2}")
    Integer messageCountToProcessAtOnce;

    @Scheduled(fixedRateString = "${message.scheduler-fixed-rate-in-ms}")
    public void schedule() {
        handler.handle(messageCountToProcessAtOnce);
    }

}
