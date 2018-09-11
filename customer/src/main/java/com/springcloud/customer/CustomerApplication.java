package com.springcloud.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class CustomerApplication {
	/*
	* 使用this.restTemplate调用服务提供者的接口
	使用ribbon 做客户端负载均衡 @LoadBalanced
	默认负载均衡的方式是轮询
	*/
	@Bean(name="remoteRestTemplate")
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
}
