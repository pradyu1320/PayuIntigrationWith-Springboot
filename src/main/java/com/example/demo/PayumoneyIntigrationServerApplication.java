package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PayumoneyIntigrationServerApplication 	extends SpringBootServletInitializer {
	private static Class applicationClass = PayumoneyIntigrationServerApplication.class;
	public static void main(String[] args) {
		SpringApplication.run(PayumoneyIntigrationServerApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(applicationClass);
	}
}
