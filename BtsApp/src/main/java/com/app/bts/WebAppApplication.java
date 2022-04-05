package com.app.bts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebAppApplication extends SpringBootServletInitializer{
	
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    	return builder.sources(WebAppApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}

}
