package com.vnjohn.sentinel.exception;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.vnjohn.common.JsonResult;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @author vnjohn
 * @since 2022/12/10
 */
public class CustomerFallbackHandler {

    public static JsonResult<String> fallbackHandler(Long id, Throwable e) {
        JsonResult<String> result = new JsonResult<>(444, "自定义 fallback 异常：出现未知商品id");
        return result;
    }

    public static ClientHttpResponse globalFallbackHandler(HttpRequest request,
                                                           byte[] body,
                                                           ClientHttpRequestExecution execution,
                                                           BlockException exception) {
        JsonResult<String> result = new JsonResult<>(444, "自定义全局 fallback 异常");
        return new SentinelClientHttpResponse(JSON.toJSONString(result));
    }

}
