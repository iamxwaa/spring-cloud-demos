package com.github.toxrink.serviceconsumerdemo.controller;

import java.util.Arrays;

import com.github.toxrink.servicecommondemo.model.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * HelloController
 */
@RestController
public class HelloController {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.address:http://service-provider-demo}")
    private String addr;

    @GetMapping("/hello")
    public Message hello() {
        Message message = restTemplate.getForObject(addr + "/hello", Message.class);
        if (null == message.getFrom()) {
            message.setFrom(new String[] { "service-consumer" });
        } else {
            String[] from = Arrays.copyOf(message.getFrom(), message.getFrom().length + 1);
            from[from.length - 1] = "service-consumer";
            message.setFrom(from);
        }
        return message;
    }

}