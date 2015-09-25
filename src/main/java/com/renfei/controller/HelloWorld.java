package com.renfei.controller;

import com.renfei.configuration.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/9/7
 * Time: 下午11:44
 */
@Controller
@EnableAutoConfiguration
public class HelloWorld {

    @Value(value = "${name}")
    private String name;

    @Autowired
    private MyConfig myConfig;

    @Autowired
    private CounterService counterService;

    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(){
        return "Hello World!!@@!";
    }

    @RequestMapping("/count")
    @ResponseBody
    public String count(){
        //递增
        counterService.increment("myapp.greet.count");
        return "success";
    }

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }


    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return name;
    }

    @RequestMapping("/my")
    @ResponseBody
    public String my() {
        return myConfig.getName()+"=="+myConfig.getAge();
    }

   /* public static void main(String[] args) {
        SpringApplication.run(HelloWorld.class, args);
    }*/

}
