package edu.umbc.cmsc447.team10.rest_service.services;

import edu.umbc.cmsc447.team10.rest_service.data.State;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public final class DataRetrievalService {
    public static final String INFECTION_API = "https://disease.sh/v3/covid-19";
    private final RestTemplate restTemplate;

    public DataRetrievalService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public State[] getAllStateInfections() {
        return restTemplate.getForObject(infectionEndpoint("states"), State[].class);
    }

    public static String infectionEndpoint(String str) {
        return String.format("%s/%s", INFECTION_API, str);
    }
}
