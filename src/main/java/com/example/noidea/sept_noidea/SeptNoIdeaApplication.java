package com.example.noidea.sept_noidea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SeptNoIdeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeptNoIdeaApplication.class, args);
    }

}
