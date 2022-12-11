package com.vnjohn.sentinel.exception;

import com.vnjohn.common.JsonResult;

/**
 * @author vnjohn
 * @since 2022/12/10
 */
public class CustomerFallbackHandler {

    public static JsonResult<String> fallbackHandler(Long id, Throwable e) {
        JsonResult<String> result = new JsonResult<>(444, "自定义 fallback 异常：出现未知商品id");
        return result;
    }

}
