package com.kkorkunc.notifier.application;

import com.kkorkunc.notifier.application.dto.ConfigurationDto;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationHandler {

    /*
        this approach is for only PoC purposes, not a fit for scalable applications
        if you want to make scalable deployments works fine, you need to manage configurations in a single source of truth,
        currently every deployment is managing its own configuration
     */
    private ConfigurationDto configuration = new ConfigurationDto();

    public void updateConfiguration(ConfigurationDto configurationDto) {
        configuration = configurationDto;
    }

    public ConfigurationDto getConfigurations() {
        return configuration;
    }

}
