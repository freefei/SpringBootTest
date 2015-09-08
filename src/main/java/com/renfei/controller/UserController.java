package com.renfei.controller;

import com.renfei.dao.UserDao;
import com.renfei.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
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
    private UserDao userDao;

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

    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping("/create")
    @ResponseBody
    public String create(String email, String name) {
        User user = null;
        try {
            user = new User(email, name);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getId() + ")";
    }

    /**
     * GET /delete  --> Delete the user having the passed id.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            User user = new User(id);
            userDao.delete(user);
        }
        catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User succesfully deleted!";
    }

    /**
     * GET /get-by-email  --> Return the id for the user having the passed
     * email.
     */
    @RequestMapping("/get-by-email")
    @ResponseBody
    public String getByEmail(@Param("email")String email) {
        String userId;
        try {
            User user = userDao.findByEmail(email);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    /**
     * GET /update  --> Update the email and the name for the user in the
     * database having the passed id.
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(long id, String email, String name) {
        try {
            User user = userDao.findOne(id);
            user.setEmail(email);
            user.setName(name);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll() {
        List<User> list = new ArrayList<User>();
        try {
            Iterable<User> users = userDao.findAll();
            for (Iterator<User> iter =users.iterator();iter.hasNext();){
                list.add(iter.next());

            }
            return list;
        }
        catch (Exception ex) {
            System.out.print("查询失败");
        }
        return list;
    }




}
