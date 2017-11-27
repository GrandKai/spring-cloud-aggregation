package com.knife.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon-consumer")
    public String hello() {
        // 一、服务消费
        // 1. URI restTemplate
        // UriComponents components = UriComponentsBuilder.fromUriString("http://HELLO-SERVICE/hello?name={name}").build().expand("grandkai").encode("utf-8");
        // URI uri = components.toUri();
        // ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);


        // 2. restTemplate.getForEntity(String url, Class responseType, Map urlVariables)
        // Map<String, String> param = new HashMap<>();
        // param.put("name", "GrandKai");
        // restTemplate.getForEntity("http://HELLO-SERVICE/hello?name={name}", String.class, param).getBody();

        // 3. restTemplate.getForEntity(String url, Class responseType, String... urlVariables)
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello?name={1}", String.class, "grandkai").getBody();
    }
}
