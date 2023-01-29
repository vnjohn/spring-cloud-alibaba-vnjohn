package com.vnjohn.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vnjohn.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author vnjohn
 * @since 2023/1/27
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
