package com.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FindServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FindServiceApplication.class, args);
    }
}
