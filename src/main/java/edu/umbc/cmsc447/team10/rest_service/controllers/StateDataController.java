package edu.umbc.cmsc447.team10.rest_service.controllers;

import edu.umbc.cmsc447.team10.rest_service.data.State;
import edu.umbc.cmsc447.team10.rest_service.services.DataCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class StateDataController {
    @Autowired
    private DataCacheService dataCacheService;

    @GetMapping("/states")
    public @ResponseBody Collection<State> states() {
        return dataCacheService.allStateData();
    }

    @GetMapping("/states/{state}")
    public @ResponseBody State byName(@PathVariable("state") String stateName) {
        return dataCacheService.byName(stateName);
    }
}
