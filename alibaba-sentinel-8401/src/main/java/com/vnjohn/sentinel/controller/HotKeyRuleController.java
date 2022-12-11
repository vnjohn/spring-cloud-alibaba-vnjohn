package com.vnjohn.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.vnjohn.sentinel.exception.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vnjohn
 * @since 2022/12/8
 */
@RestController
public class HotKeyRuleController {

    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey", blockHandler = "hotKeyBlockHandler")
    public String hotKey(@RequestParam(required = false) String hot1,
                         @RequestParam(required = false) String hot2,
                         @RequestParam(required = false) String hot3) {
        return "HotKeyRule#hotKey";
    }

    // 方法签名需要和引用该方法接口的方法签名保持一致
    public String hotKeyBlockHandler(String hot1, String hot2, String hot3, BlockException exception) {
        return "热点规则-限流异常";
    }

    @GetMapping("/customerBlock")
    @SentinelResource(value = "customerBlock", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerBlockException")
    public String customerBlock(@RequestParam(required = false) String hot) {
        return "HotKeyRule#customerBlock";
    }

}
