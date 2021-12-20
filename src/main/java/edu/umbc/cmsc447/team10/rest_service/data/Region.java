package edu.umbc.cmsc447.team10.rest_service.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.Map;

public abstract class Region implements Serializable {
    @JsonProperty
    public long population;

    public InfectionInfo infectionInfo;
    public VaccineInfo vaccineInfo;

    @JsonCreator
    public Region(final Map<String, Object> properties) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            population = Long.parseLong(properties.get("population").toString());
            String actuals = mapper.writeValueAsString(properties.get("actuals"));
            infectionInfo = mapper.readValue(actuals, InfectionInfo.class);
            vaccineInfo = mapper.readValue(actuals, VaccineInfo.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
