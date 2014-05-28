package com.cagnosolutions.cei.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

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

//	@Bean
//	public EmbeddedServletContainerCustomizer containerCustomizer() {
//		return new EmbeddedServletContainerCustomizer(){
//			
//			public void customize(ConfigurableEmbeddedServletContainer container) {
//				ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
//				ErrorPage error401 = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
//				ErrorPage error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
//				container.addErrorPages(error404, error401, error500);
//			}
//		};
//	} 
}
