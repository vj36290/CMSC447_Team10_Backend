package edu.umbc.cmsc447.team10.rest_service.services;

import edu.umbc.cmsc447.team10.rest_service.configurations.DataCacheConfiguration;
import edu.umbc.cmsc447.team10.rest_service.data.County;
import edu.umbc.cmsc447.team10.rest_service.data.USRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public final class DataRetrievalService {
    public static final String COVID_API_BASE = "https://api.covidactnow.org/v2/";
    private static final String US_STATES_REGION = "states";
    private static final String US_COUNTIES_REGION = "counties";

    @Autowired
    private DataCacheConfiguration dataCacheConfiguration;

    private final RestTemplate restTemplate;

    public DataRetrievalService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public USRegion[] getAllStateInfections() {
        return getUSData(USRegion[].class, US_STATES_REGION);
    }

    public County[] getAllCountyInfections() {
        return getUSData(County[].class, US_COUNTIES_REGION);
    }

    public String infectionEndpoint(String str) {
        return String.format("%s%s.json?apiKey=%s", COVID_API_BASE, str, dataCacheConfiguration.getApiKey());
    }

    private <T extends USRegion> T[] getUSData(Class<T[]> tClass, String regionType) {
        return restTemplate.getForObject(infectionEndpoint(regionType), tClass);
    }
}
