package com.vnjohn.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author vnjohn
 * @Date 2022/8/8
 */
@RestController
public class DemoController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("serverPort")
    public String serverPort() {
        return "Hello Nacos Discovery" + serverPort;
    }

}
