package com.changddao.goorm_response_error;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GoormResponseErrorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoormResponseErrorApplication.class, args);
	}

}
