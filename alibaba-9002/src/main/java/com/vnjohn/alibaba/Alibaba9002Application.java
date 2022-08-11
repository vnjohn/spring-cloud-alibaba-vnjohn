package com.vnjohn.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Alibaba9002Application {

    public static void main(String[] args) {
        SpringApplication.run(Alibaba9002Application.class, args);
    }

}
