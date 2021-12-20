package edu.umbc.cmsc447.team10.rest_service.data;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InfectionInfo extends Info implements Serializable {
    @JsonAlias("cases")
    public long totalCases;
    public long newCases;

    @JsonAlias("deaths")
    public long totalDeaths;
    public long newDeaths;
}
