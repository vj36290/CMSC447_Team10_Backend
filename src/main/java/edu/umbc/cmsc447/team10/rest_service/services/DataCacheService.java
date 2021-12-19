package edu.umbc.cmsc447.team10.rest_service.services;

import edu.umbc.cmsc447.team10.rest_service.configurations.DataCacheConfiguration;
import edu.umbc.cmsc447.team10.rest_service.data.State;
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

    public Map<String, State> stateCache;

    public DataCacheService() {
        stateCache = new HashMap<>();
    }

    public State byName(String name) {
        if (shouldUpdateCache())
            updateCache();
        return stateCache.get(name.toLowerCase());
    }

    public Collection<State> allStateData() {
        return stateCache.values();
    }

    /**
     * @return Whether or not the cache of vaccine/case information should be updated, based on the last update time and
     * configured update interval.
     */
    private boolean shouldUpdateCache() {
        return System.currentTimeMillis() > lastUpdateTime + dataCacheConfiguration.getUpdateInterval() * 1000;
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
        lastUpdateTime = System.currentTimeMillis();
    }
}
