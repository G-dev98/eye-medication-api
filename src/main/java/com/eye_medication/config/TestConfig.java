package com.eye_medication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eye_medication.Service.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	DBService dbService;

	@Bean
	public void instanciaBaseDeDados(){
		this.dbService.instanciaBaseDados();
	}

}
