package edu.umbc.cmsc447.team10.rest_service.data;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Map;

public class County extends USRegion {
    @JsonCreator
    public County(Map<String, Object> properties) {
        super(properties);
    }
}