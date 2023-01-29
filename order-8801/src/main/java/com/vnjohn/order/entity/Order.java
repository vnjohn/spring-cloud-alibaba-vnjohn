package com.vnjohn.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vnjohn
 * @since 2023/1/27
 */
@Data
@Builder
@TableName("`order`")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long productId;

    private Integer count;

}
