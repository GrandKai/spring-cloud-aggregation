package com.knife.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @GetMapping("hello1")
    public String hello(@RequestParam("name") String name);

    @GetMapping("hello2")
    public String hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
}
