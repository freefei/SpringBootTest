package com.renfei.controller;

import com.renfei.model.User;
import com.renfei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

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

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/all")
    @ResponseBody
    public List<User> findAll() {

        return userService.findAll();
    }

    @RequestMapping("/database")
    @ResponseBody
    public String database() throws SQLException {

        return dataSource.getConnection().getMetaData().getDatabaseProductName();
    }


    @RequestMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable(value = "id") String id) {

       return userService.findUser(Long.valueOf(id));

    }

    @RequestMapping("/{id}/insert")
    @ResponseBody
    public String setUserName(@PathVariable(value = "id") String id) {

        userService.setUserName(Long.valueOf(id));

        return "ok";

    }


    @RequestMapping("/{id}/query")
    @ResponseBody
    public String getUserName(@PathVariable(value = "id") String id) {

        return userService.getUserName(Long.valueOf(id));

    }

    @RequestMapping("/{id}/del")
    @ResponseBody
    public String delUserName(@PathVariable(value = "id") String id) {

        userService.deleteUserName(Long.valueOf(id));

        return "ok";

    }







}
