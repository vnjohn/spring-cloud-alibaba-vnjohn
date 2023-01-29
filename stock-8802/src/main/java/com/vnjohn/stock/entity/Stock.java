package com.vnjohn.stock.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author vnjohn
 * @since 2023/1/27
 */
@Data
@TableName("stock")
public class Stock {
    private Long productId;

    private Integer count;

}
