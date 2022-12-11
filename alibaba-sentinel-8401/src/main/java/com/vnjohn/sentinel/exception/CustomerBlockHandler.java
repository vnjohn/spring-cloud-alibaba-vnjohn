package com.vnjohn.sentinel.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 自定义限流异常处理类
 * @author vnjohn
 * @since 2022/12/9
 */
public class CustomerBlockHandler {

    public static String handlerBlockException(String hot, BlockException exception) {
        return "自定义限流异常：CustomerBlockHandler#handlerBlockException";
    }

    public static String sameTimeHandlerBlockException(Long id, BlockException exception) {
        return "自定义限流异常：CustomerBlockHandler#sameTimeHandlerBlockException";
    }

}
