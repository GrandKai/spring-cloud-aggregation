package com.knife.cloud.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/refactor")
public interface IHelloService {

    @GetMapping("/hello3")
    String hello(@RequestParam(value = "name") String name);

    @GetMapping("/hello4")
    String hello(@RequestHeader("name") String name, @RequestHeader(value = "age") Integer age);
}
