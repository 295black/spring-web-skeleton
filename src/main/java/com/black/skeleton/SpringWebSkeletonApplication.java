package com.black.skeleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringWebSkeletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebSkeletonApplication.class, args);
	}

}
