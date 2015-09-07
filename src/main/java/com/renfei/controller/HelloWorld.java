package com.renfei.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/9/7
 * Time: 下午11:44
 */
@Controller
@EnableAutoConfiguration
public class HelloWorld {
    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(){
        return "Hello World";
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloWorld.class, args);
    }

}
