package edu.umbc.cmsc447.team10.rest_service.data;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import edu.umbc.cmsc447.team10.rest_service.data.InfectionInfo;
import edu.umbc.cmsc447.team10.rest_service.data.VaccineInfo;

import java.io.Serializable;

public class State implements Serializable {
    public String state;
    public long population;

    @JsonUnwrapped
    public InfectionInfo infectionInfo;
    @JsonUnwrapped
    public VaccineInfo vaccineInfo;

    public String toString() {
        return String.format(
                "%s\nPopulation: %s\n" +
                        "===============================\n" +
                        "%s\n%s\n",
                state, population, infectionInfo, vaccineInfo
        );
    }
}
