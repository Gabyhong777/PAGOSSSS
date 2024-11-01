package com.gpf.Pagos04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.gpf.Pagos04.Repositorio") 
public class Pagos04Application {

	public static void main(String[] args) {
		SpringApplication.run(Pagos04Application.class, args);
	}

}


