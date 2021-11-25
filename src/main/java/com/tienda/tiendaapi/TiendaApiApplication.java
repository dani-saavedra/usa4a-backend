package com.tienda.tiendaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TiendaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaApiApplication.class, args);
	}

}
