package com.knife.cloud.controller;

import com.knife.cloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignConsumerController {

    @Autowired
    HelloService helloService;

    @GetMapping("feign-consumer")
    public String helloConsumer() {
        return helloService.hello();
    }
}
