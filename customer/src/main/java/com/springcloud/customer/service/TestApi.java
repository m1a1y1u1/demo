package com.springcloud.customer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "EUREKA-CLIENT-PROVIDER",fallback = RuntimeException.class)
public interface TestApi {

    @GetMapping("/hello")
    public String hello();
}
