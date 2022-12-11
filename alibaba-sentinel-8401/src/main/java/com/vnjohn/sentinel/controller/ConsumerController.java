package com.vnjohn.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.vnjohn.common.JsonResult;
import com.vnjohn.sentinel.exception.CustomerBlockHandler;
import com.vnjohn.sentinel.exception.CustomerFallbackHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author vnjohn
 * @since 2022/12/9
 */
@RestController
public class ConsumerController {
    /**
     * 服务提供者URL
     */
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/{id}")
    public JsonResult<String> consumer(@PathVariable Long id) {
        //通过 Ribbon 发起远程访问，访问 9001/9002
        JsonResult<String> result = restTemplate.getForObject(serviceUrl + "/info/" + id, JsonResult.class);
        return result;
    }

    @GetMapping("/fallback/{id}")
    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "fallbackHandler", exceptionsToIgnore = {NullPointerException.class})
    public JsonResult<String> fallback(@PathVariable Long id) {
        if (id <= 3) {
            //通过Ribbon发起远程访问，访问9003/9004
            JsonResult<String> result = restTemplate.getForObject(serviceUrl + "/info/" + id, JsonResult.class);
            System.err.println(result.getData());
            return result;
        } else {
            throw new NullPointerException("没有对应的数据记录");
        }
    }

    /**
     * 保证方法签名与原方法一致，还需额外增加一个异常类型参数
     */
    public JsonResult<String> fallbackHandler(Long id, Throwable e) {
        JsonResult<String> result = new JsonResult<>(444, "fallbackHandler 出现未知商品id");
        return result;
    }

    /**
     * 保证方法签名与原方法一致，还需额外增加一个异常类型参数
     */
    public JsonResult<String> blockHandler(Long id, BlockException e) {
        JsonResult<String> result = new JsonResult<>(444, "blockHandler 出现未知商品id");
        return result;
    }

}
