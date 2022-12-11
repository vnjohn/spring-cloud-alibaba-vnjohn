package com.vnjohn.sentinel.controller;

import com.vnjohn.common.JsonResult;
import com.vnjohn.sentinel.service.OpenFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author vnjohn
 * @since 2022/12/11
 */
@RestController
public class OpenFeignController {
    @Resource
    private OpenFeignService openFeignService;

    @GetMapping("info/{id}")
    public JsonResult<String> info(@PathVariable("id") Long id) {
        if (id > 3) {
            throw new RuntimeException("没有该 id");
        }
        return openFeignService.info(id);
    }
}
