package edu.umbc.cmsc447.team10.rest_service.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class USRegion extends Region {
    @JsonProperty
    public String state;

    @JsonProperty
    public String county;

    @JsonProperty
    public String fips;

    @JsonCreator
    public USRegion(Map<String, Object> properties) {
        super(properties);
        state = (String) properties.get("state");
        county = (String) properties.get("county");
        fips = (String) properties.get("fips");
    }
}
