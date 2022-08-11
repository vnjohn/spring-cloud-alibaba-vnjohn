package com.example.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author vnjohn
 * @Date 2022/8/9
 */
@RestController
@RefreshScope
public class ConfigInfoController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("config/info")
    public String configInfo() {
        return configInfo;
    }
}
