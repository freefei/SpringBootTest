package com.renfei.controller;

import com.renfei.model.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/9/7
 * Time: 下午11:52
 */

@EnableAutoConfiguration
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/{id}")
    public User view(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("zhang");
        return user;
    }

    //public static void main(String[] args) {
    //    SpringApplication.run(UserController.class);
    //}
}
