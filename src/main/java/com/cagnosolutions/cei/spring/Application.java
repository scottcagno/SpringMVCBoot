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
		
		
		 String banner = "   ___        _               _                   _   __   \n" +
		 "  / __|  _ __| |_ ___ _ __   /_\\  _ __ _ __  __ _/ | /  \\ \n" +
		 " | (_| || (_-<  _/ _ \\ '  \\ / _ \\| '_ \\ '_ \\ \\ V / || () |\n" +
		 "  \\___\\_,_/__/\\__\\___/_|_|_/_/ \\_\\ .__/ .__/  \\_/|_(_)__/ \n" +
		 "                                 |_|  |_|                 \n\n" +	
				            "Powered by ::SpringBoot::\n";
		System.out.println(banner);
		SpringApplication app = new SpringApplication(Application.class);
		app.setShowBanner(false);
		app.run(args);
	}
}
