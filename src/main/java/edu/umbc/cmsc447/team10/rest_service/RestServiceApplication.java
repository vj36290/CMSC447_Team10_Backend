package edu.umbc.cmsc447.team10.rest_service;

import edu.umbc.cmsc447.team10.rest_service.services.DataCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication {
	@Autowired
	private DataCacheService dataCacheService;

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}
}
