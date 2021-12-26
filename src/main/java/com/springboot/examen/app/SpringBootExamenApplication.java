package com.springboot.examen.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.springboot.examen.app")
public class SpringBootExamenApplication extends SpringBootServletInitializer {

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootExamenApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExamenApplication.class, args);
	}

}
