package com.example.hexa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HexaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexaApplication.class, args);
    }

}
