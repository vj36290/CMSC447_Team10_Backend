package edu.umbc.cmsc447.team10.rest_service;

import edu.umbc.cmsc447.team10.rest_service.data.State;
import edu.umbc.cmsc447.team10.rest_service.services.DataCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@SpringBootApplication
public class RestServiceApplication {
	@Autowired
	private DataCacheService dataCacheService;

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println(dataCacheService.byName("maryland"));
		};
	}
}
