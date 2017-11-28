package com.example.helloservice;

import com.knife.cloud.service.IHelloService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController implements IHelloService {
    @Override
    public String hello(String name) {
        return "hello " + name;
    }

    @Override
    public String hello(String name, Integer age) {
        return "hello " + name + ", " + age;
    }
}
