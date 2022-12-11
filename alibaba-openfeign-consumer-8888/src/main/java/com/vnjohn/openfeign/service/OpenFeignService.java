package com.vnjohn.openfeign.service;

import com.vnjohn.common.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 此接口用于配合使用 OpenFeign 接口
 * 在此接口中添加 @FeignClient 接口同时标注要调用的服务名称
 * 同时使用与服务提供者方法签名保持一致的抽象方法来表示远程调用的具体内容
 * @PathVariable、@Param、@RequestBody 注解参数都需要和原方法保持一致，不可缺少，否则调用时会报错
 * @GetMapping 请求使用到对象进行查询时，需要使用 @QueryMap 将其扩展为字符串，否则调用时也会报错
 * @author vnjohn
 * @since 2022/12/10
 */
@Service
@FeignClient("alibaba-provider")
public interface OpenFeignService {
    @GetMapping("info/{id}")
    JsonResult<String> info(@PathVariable("id") Long id);

    @GetMapping("timeout")
    String timeout();
}
