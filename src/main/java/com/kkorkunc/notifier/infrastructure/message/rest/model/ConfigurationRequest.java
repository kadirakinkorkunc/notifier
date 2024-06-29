package com.kkorkunc.notifier.infrastructure.message.rest.model;

import com.kkorkunc.notifier.application.dto.ConfigurationDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfigurationRequest {
    boolean messageSendJobWorking;

    public ConfigurationDto to() {
        return new ConfigurationDto(messageSendJobWorking);
    }
}
