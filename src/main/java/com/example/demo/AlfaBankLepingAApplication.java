package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlfaBankLepingAApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlfaBankLepingAApplication.class, args);
    }

}
