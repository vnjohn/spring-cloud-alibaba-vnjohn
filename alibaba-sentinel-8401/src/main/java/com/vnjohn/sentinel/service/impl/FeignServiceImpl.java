package com.vnjohn.sentinel.service.impl;

import com.vnjohn.common.JsonResult;
import com.vnjohn.sentinel.service.OpenFeignService;
import org.springframework.stereotype.Component;

/**
 * @author vnjohn
 * @since 2022/12/11
 */
@Component
public class FeignServiceImpl implements OpenFeignService {
    @Override
    public JsonResult<String> info(Long id) {
        return new JsonResult<>(444, "服务降级返回！");
    }
}
