package com.cagnosolutions.cei.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application  {

	public static void main(String[] args) {
		SpringApplication.run(com.cagnosolutions.cei.spring.Application.class, args);
	}
}
