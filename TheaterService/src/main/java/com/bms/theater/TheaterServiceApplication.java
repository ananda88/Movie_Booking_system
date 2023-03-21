package com.bms.theater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class TheaterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheaterServiceApplication.class, args);
	}

}
