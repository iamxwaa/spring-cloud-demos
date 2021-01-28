package com.github.iamxwaa.serviceproviderdemo.controller;

import com.github.iamxwaa.servicecommondemo.model.Message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${test.message:this is test}")
    private String testMessage;

    @GetMapping("/hello")
    public Message hello() {
        Message message = new Message();
        message.setFrom(new String[] { "service-provider" });
        message.setMessage(testMessage);
        return message;
    }
}