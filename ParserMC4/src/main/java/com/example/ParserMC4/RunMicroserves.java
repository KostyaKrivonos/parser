package com.example.ParserMC4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:spring.xml"})
public class RunMicroserves {
    public static void main(String[] args) {
        SpringApplication.run(RunMicroserves.class, args);
    }

}
