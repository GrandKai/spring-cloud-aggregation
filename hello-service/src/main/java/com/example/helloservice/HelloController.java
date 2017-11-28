package com.example.helloservice;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    Logger logger = Logger.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String index() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host: " + instance.getHost() + ", service_id: " + instance.getServiceId());
        return "hello cloud";
    }

    @GetMapping("hello1")
    public String hello(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello2")
    public String hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return "hello " + name + ", " + age;
    }
}
