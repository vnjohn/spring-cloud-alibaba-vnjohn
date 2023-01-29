package com.vnjohn.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author vnjohn
 * @since 2023/1/27
 */
@Service
@FeignClient("stock-8802")
public interface StockClient {

    /**
     * 减少指定商品的库存
     * @param productId 商品 id
     */
    @GetMapping("/decrement/{productId}")
    void decrement(@PathVariable("productId") Long productId);

}
