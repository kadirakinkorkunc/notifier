package com.kkorkunc.notifier.infrastructure.message.job;

import com.kkorkunc.notifier.application.ConfigurationHandler;
import com.kkorkunc.notifier.application.ProcessMessagesCommandHandler;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageProcessJob {

    private static final Logger LOG = LoggerFactory.getLogger(MessageProcessJob.class);

    @Autowired
    ProcessMessagesCommandHandler handler;

    @Autowired
    ConfigurationHandler configurationHandler;

    @Value("${message.count-to-process-at-once:2}")
    Integer messageCountToProcessAtOnce;

    @Scheduled(fixedRateString = "${message.scheduler-fixed-rate-in-ms}")
    public void schedule() {
        if (!configurationHandler.getConfigurations().isMessageSendJobWorking()) {
            LOG.info("Message process job seems disabled, skipping without taking any action");
            return;
        }

        LOG.info("Message process job started");
        handler.handle(messageCountToProcessAtOnce);
    }

}
