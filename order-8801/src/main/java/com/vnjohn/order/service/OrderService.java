package com.vnjohn.order.service;

/**
 * @author vnjohn
 * @since 2023/1/27
 */
public interface OrderService {
    /**
     * 创建指定商品的订单以及减少库存
     *
     * @param productId
     */
    boolean create(Long productId);
}
