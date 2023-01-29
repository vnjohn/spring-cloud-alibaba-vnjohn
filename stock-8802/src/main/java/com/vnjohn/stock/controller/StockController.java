package com.vnjohn.stock.controller;

import com.vnjohn.stock.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author vnjohn
 * @since 2023/1/27
 */
@RestController
public class StockController {
    @Resource
    private StockService stockService;

    @GetMapping("/decrement/{productId}")
    public void decrement(@PathVariable Long productId) {
        stockService.decrement(productId);
    }

}
