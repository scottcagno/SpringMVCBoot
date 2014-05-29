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
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer(){
			public void customize(ConfigurableEmbeddedServletContainer container) {
				ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
				ErrorPage error401 = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
				ErrorPage error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
				container.addErrorPages(error404, error401, error500);
			}
		};
	} 
}
