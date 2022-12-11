package com.vnjohn.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author vnjohn
 * @since 2022/12/8
 */
@RestController
public class FusingRuleController {

    /**
     * 最少请求数：5、统计时长：1000ms、RT：最大响应时间 300ms、阀值：0.2
     * @return method desc
     */
    @GetMapping("/slowRatio")
    public String slowRatio() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "FusingRule#slowRatio";
    }

    @GetMapping("/exceptionRatio")
    public String exceptionRatio(Integer id) {
        if(id!=null && id > 1) {
            throw new RuntimeException("异常比例测试");
        }
        return "FusingRule#exceptionRatio";
    }

    @GetMapping("/exceptionCount")
    public String exceptionCount(Integer id) {
        if(id!=null && id > 1) {
            throw new RuntimeException("异常数测试");
        }
        return "FusingRule#exceptionCount";
    }

}
