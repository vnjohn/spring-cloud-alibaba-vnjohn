package com.vnjohn.order.controller;

import com.vnjohn.common.JsonResult;
import com.vnjohn.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author vnjohn
 * @since 2023/1/27
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GlobalTransactional
    @GetMapping("/create/{productId}")
    public JsonResult<String> create(@PathVariable Long productId) {
        boolean result = orderService.create(productId);
        if (result) {
            return JsonResult.success();
        }
        return JsonResult.fail();
    }

}