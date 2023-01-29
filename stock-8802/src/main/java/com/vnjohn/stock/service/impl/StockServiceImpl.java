package com.vnjohn.stock.service.impl;

import com.vnjohn.stock.mapper.StockMapper;
import com.vnjohn.stock.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author vnjohn
 * @since 2023/1/27
 */
@Service
public class StockServiceImpl implements StockService {
    @Resource
    private StockMapper stockMapper;

    @Override
    public void decrement(Long productId) {
        stockMapper.decrement(productId);
    }
}
