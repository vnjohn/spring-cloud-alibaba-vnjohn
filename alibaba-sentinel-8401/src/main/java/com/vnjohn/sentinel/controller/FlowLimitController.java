package com.vnjohn.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.vnjohn.sentinel.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author vnjohn
 * @since 2022/12/5
 */
@RestController
public class FlowLimitController {
    private static final Logger log = LoggerFactory.getLogger(FlowLimitController.class);


    @Autowired
    private CommonService commonService;

    @GetMapping("/linkA")
    public String linkA() {
//        return commonService.common();
        return "linkA";
    }

    @GetMapping("/linkB")
    public String linkB() {
        return commonService.common();
    }

    @GetMapping("/warmUp")
    public String warmUp() {
        return "FlowLimit#warmUp";
    }

    @GetMapping("/uniform-pending")
    public String uniformPending() throws InterruptedException {
        log.info(Thread.currentThread().getName() + "：uniformPending");
        return "FlowLimit#uniform-pending";
    }

    @GetMapping("/testA")
    @SentinelResource("testA")
    public String testA() {
        return "-----testA";
    }

    @GetMapping("/test")
    @SentinelResource("test")
    public String test() {
        return "-----test";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-----testB";
    }

}
