package com.ritaum.travel.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = { "com.ritaum.travel" })
@PropertySource(value = { "classpath:application.properties" })
@EnableAsync
public class TravelBootApp {

	public static void main(String[] args) {
        SpringApplication.run(TravelBootApp.class, args);
    }
	
}
