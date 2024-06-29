package com.kkorkunc.notifier.infrastructure.message.cache;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ExternalStorage {

    public static final String MESSAGE_CACHE_HASH_KEY = "sent_messages";

    @Resource(name = "redisTemplate")
    RedisTemplate<String, String> redisTemplate;

    public void storeMessageMetadata(LocalDateTime time, String messageId) {
        redisTemplate.opsForHash().put(MESSAGE_CACHE_HASH_KEY, messageId, time.format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
