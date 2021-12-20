package edu.umbc.cmsc447.team10.rest_service.services;

import edu.umbc.cmsc447.team10.rest_service.configurations.DataCacheConfiguration;
import edu.umbc.cmsc447.team10.rest_service.data.County;
import edu.umbc.cmsc447.team10.rest_service.data.USRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class DataCacheService {
    @Autowired
    private DataCacheConfiguration dataCacheConfiguration;

    @Autowired
    private DataRetrievalService dataRetrievalService;

    private long lastUpdateTime;

    public Map<String, USRegion> stateCache;
    public Map<String, County> countyCache;

    public DataCacheService() {
        stateCache = new HashMap<>();
        countyCache = new HashMap<>();
    }

    public USRegion byStateName(String name) {
        if (shouldUpdateCache())
            updateCache();
        return stateCache.get(name.toLowerCase());
    }

    public Collection<USRegion> allStateData() {
        if (shouldUpdateCache())
            updateCache();
        return stateCache.values();
    }

    public County byCountyFips(String fips) {
        if (shouldUpdateCache())
            updateCache();
        return countyCache.get(fips);
    }

    public Collection<County> allCountyData() {
        if (shouldUpdateCache())
            updateCache();
        return countyCache.values();
    }

    /**
     * @return Whether or not the cache of vaccine/case information should be updated, based on the last update time and
     * configured update interval.
     */
    private boolean shouldUpdateCache() {
        return System.currentTimeMillis() > lastUpdateTime + (dataCacheConfiguration.getUpdateInterval() * 1000);
    }

    /**
     * Updates cached data.
     */
    private void updateCache() {
        long interval = dataCacheConfiguration.getUpdateInterval();
        System.out.printf("Last update was more than %s second%s ago. Requesting updates...\n",
                interval, interval == 1 ? "" : "s");
        Arrays.stream(dataRetrievalService.getAllStateInfections()).forEach(state ->
            stateCache.put(state.state.toLowerCase(), state)
        );
        Arrays.stream(dataRetrievalService.getAllCountyInfections()).forEach(county ->
                countyCache.put(county.fips, county));
        lastUpdateTime = System.currentTimeMillis();
    }
}
