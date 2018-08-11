package com.appevento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.appevento.controllers"})
public class AppeventoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppeventoApplication.class, args);
	}
}
