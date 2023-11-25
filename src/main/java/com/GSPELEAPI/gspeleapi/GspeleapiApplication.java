package com.GSPELEAPI.gspeleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.GSPELEAPI.gspeleapi")
public class GspeleapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GspeleapiApplication.class, args);
	}

}
