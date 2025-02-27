package com.example.liquibasebug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LiquibaseBugApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiquibaseBugApplication.class, args);
    }

}
