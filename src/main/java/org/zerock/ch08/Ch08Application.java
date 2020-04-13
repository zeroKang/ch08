package org.zerock.ch08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Ch08Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch08Application.class, args);
	}

}


