package edu.umbc.cmsc447.team10.rest_service.controllers;

import edu.umbc.cmsc447.team10.rest_service.data.County;
import edu.umbc.cmsc447.team10.rest_service.data.USRegion;
import edu.umbc.cmsc447.team10.rest_service.services.DataCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class USRegionDataController {
    @Autowired
    private DataCacheService dataCacheService;

    @GetMapping("/states")
    public @ResponseBody
    Collection<USRegion> states() {
        return dataCacheService.allStateData();
    }

    @GetMapping("/states/{state}")
    public @ResponseBody
    USRegion byStateName(@PathVariable("state") String stateName) {
        return dataCacheService.byStateName(stateName);
    }

    @GetMapping("/counties")
    public @ResponseBody
    Collection<County> counties() {
        return dataCacheService.allCountyData();
    }

    @GetMapping("/counties/{fips}")
    public @ResponseBody
    County byCountyFips(@PathVariable("fips") String fips) {
        return dataCacheService.byCountyFips(fips);
    }
}
