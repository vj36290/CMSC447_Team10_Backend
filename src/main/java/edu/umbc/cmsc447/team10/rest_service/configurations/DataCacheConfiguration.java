package edu.umbc.cmsc447.team10.rest_service.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataCacheConfiguration {
    @Value("${update-interval}")
    private long updateInterval;

    @Value("${api-key}")
    private String apiKey;

    public long getUpdateInterval() {
        return updateInterval;
    }

    public String getApiKey() {
        return apiKey;
    }
}
