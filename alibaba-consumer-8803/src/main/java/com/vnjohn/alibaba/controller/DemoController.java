package com.vnjohn.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author vnjohn
 * @Date 2022/8/8
 */
@RestController
public class DemoController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceURL;


    @GetMapping("consumer/nacos")
    public String getDiscovery() {
        return restTemplate.getForObject(serviceURL + "/serverPort", String.class);
    }

}
