package com.vnjohn.sentinel.exception;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.vnjohn.common.JsonResult;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

/**
 * 自定义限流异常处理类
 * @author vnjohn
 * @since 2022/12/9
 */
public class CustomerBlockHandler {

    public static String handlerBlockException(String hot, BlockException exception) {
        return "自定义限流异常：CustomerBlockHandler#handlerBlockException";
    }

    public static ClientHttpResponse globalHandlerBlockException(HttpRequest request,
                                                                 byte[] body,
                                                                 ClientHttpRequestExecution execution,
                                                                 BlockException exception) {
        JsonResult<String> jsonResult = new JsonResult<>(444, "自定义限流异常：CustomerBlockHandler#globalHandlerBlockException");
        return new SentinelClientHttpResponse(JSON.toJSONString(jsonResult));
    }

    public static String sameTimeHandlerBlockException(Long id, BlockException exception) {
        return "自定义限流异常：CustomerBlockHandler#sameTimeHandlerBlockException";
    }

}
