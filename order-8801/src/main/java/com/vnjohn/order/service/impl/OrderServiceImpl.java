package com.vnjohn.order.service.impl;

import com.vnjohn.order.client.StockClient;
import com.vnjohn.order.entity.Order;
import com.vnjohn.order.mapper.OrderMapper;
import com.vnjohn.order.service.OrderService;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author vnjohn
 * @since 2023/1/27
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StockClient stockClient;

    @Override
    public boolean create(Long productId) {
        // 减库存
        stockClient.decrement(productId);

        // 新增模拟异常.
        int i = 1/0;

        // 创建订单
        return orderMapper.insert(Order.builder().productId(productId).count(RandomUtils.nextInt()).build()) > 0;
    }

}
