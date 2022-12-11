package com.vnjohn.openfeign;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaOpenfeignConsumer8888Application {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaOpenfeignConsumer8888Application.class, args);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        // 开启详细日志记录功能
        return Logger.Level.FULL;
    }

}
