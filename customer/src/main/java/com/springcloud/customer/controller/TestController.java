package com.springcloud.customer.controller;

import com.springcloud.customer.service.TestApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
class TestController {
    private static final Logger log= LoggerFactory.getLogger(TestController.class);

    @Resource(name="remoteRestTemplate")
    private RestTemplate restTemplate;

    @Resource
    private TestApi api;
    @GetMapping("/hello")
    public String hello(){
        return this.restTemplate.getForEntity("http://EUREKA-CLIENT-PROVIDER/hello",String.class).getBody();
    }

    @GetMapping("/hello1")
    public String hello1(){
        log.info("调用forage:");
        return this.api.hello();
    }
}
