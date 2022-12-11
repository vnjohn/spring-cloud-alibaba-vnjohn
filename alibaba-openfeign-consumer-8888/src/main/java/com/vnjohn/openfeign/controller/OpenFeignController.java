package com.vnjohn.openfeign.controller;

import com.vnjohn.common.JsonResult;
import com.vnjohn.openfeign.service.OpenFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author vnjohn
 * @since 2022/12/10
 */
@RestController
public class OpenFeignController {

    @Resource
    private OpenFeignService openFeignService;

    @GetMapping("/getInfo/{id}")
    public JsonResult<String> getInfo(@PathVariable("id") Long id) {
        return openFeignService.info(id);
    }

    @GetMapping("printTimeout")
    public String printTimeout() {
        return openFeignService.timeout();
    }

}
