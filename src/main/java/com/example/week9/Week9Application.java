package com.example.week9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:localConfig.properties")
@SpringBootApplication
public class Week9Application {

    public static void main(String[] args) {
        SpringApplication.run(Week9Application.class, args);
    }

}
