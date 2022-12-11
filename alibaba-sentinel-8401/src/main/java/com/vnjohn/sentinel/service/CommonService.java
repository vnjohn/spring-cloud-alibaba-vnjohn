package com.vnjohn.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author vnjohn
 * @since 2022/12/6
 */
@Service
public class CommonService {

    @SentinelResource("common")
    public String common() {
        return "CommonService#common";
    }
}
