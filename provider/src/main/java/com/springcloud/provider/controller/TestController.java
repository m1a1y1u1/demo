package com.springcloud.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class TestController {
    private static final Logger log= LoggerFactory.getLogger(TestController.class);
    @Autowired
    private Registration registration;// 服务注册
    @Autowired
    private DiscoveryClient client;
    @GetMapping("/hello")
    public String hello(){
        List<ServiceInstance> instances = client.getInstances(registration.getServiceId());
        if (instances != null && instances.size() > 0) {
            log.info("/hello,host:" + instances.get(0).getHost()+", service_id:"+instances.get(0).getServiceId());
        }
        return "hello,provider";
    }
}
