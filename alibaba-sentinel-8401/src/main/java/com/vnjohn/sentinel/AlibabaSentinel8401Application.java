package com.vnjohn.sentinel;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.vnjohn.sentinel.exception.CustomerBlockHandler;
import com.vnjohn.sentinel.exception.CustomerFallbackHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaSentinel8401Application {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinel8401Application.class, args);
    }

    /**
     * 资源名:
     * 	httpmethod:schema://host:port/path ：协议、主机、端口和路径
     * 	httpmethod:schema://host:port ：协议、主机和端口
     */
    @Bean
    @LoadBalanced
    @SentinelRestTemplate(blockHandler = "globalHandlerBlockException", blockHandlerClass = CustomerBlockHandler.class,
            fallback = "globalFallbackHandler", fallbackClass = CustomerFallbackHandler.class)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
