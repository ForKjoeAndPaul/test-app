package ru.derevenskikh.TraineeTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TraineeTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraineeTestApplication.class, args);
	}
}
