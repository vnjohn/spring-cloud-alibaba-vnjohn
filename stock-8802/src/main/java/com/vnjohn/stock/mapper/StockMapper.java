package com.vnjohn.stock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vnjohn.stock.entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author vnjohn
 * @since 2023/1/27
 */
@Mapper
public interface StockMapper extends BaseMapper<Stock> {

    void decrement(@Param("productId") Long productId);
}
