package edu.umbc.cmsc447.team10.rest_service.data;

import java.io.Serializable;

public class InfectionInfo extends Info implements Serializable {
    public long cases;
    public long todayCases;
    public long deaths;
    public long todayDeaths;
    public long recovered;
    public long active;
    public long casesPerOneMillion;
    public long deathsPerOneMillion;
    public long tests;
    public long testsPerMillion;
}
