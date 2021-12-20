package edu.umbc.cmsc447.team10.rest_service.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VaccineInfo extends Info implements Serializable {
    public long totalFullyVaccinated;
    public long totalVaccinationsAdministered;
    public long vaccinationsInitiated;
    public long vaccinationsCompleted;
    public long vaccinesDistributed;
}
