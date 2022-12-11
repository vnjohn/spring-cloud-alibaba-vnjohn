package com.vnjohn.sentinel.service;

import com.vnjohn.common.JsonResult;
import com.vnjohn.sentinel.service.impl.FeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author vnjohn
 * @since 2022/12/11
 */
// 当没有成功调用 /info/{id} 接口时会走 fallback 属性中标注的类型处理方法
@Service
@FeignClient(value = "alibaba-provider", fallback = FeignServiceImpl.class)
public interface OpenFeignService {
    @GetMapping("info/{id}")
    JsonResult<String> info(@PathVariable("id") Long id);
}
