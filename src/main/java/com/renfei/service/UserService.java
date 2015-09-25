package com.renfei.service;

import com.renfei.model.User;
import com.renfei.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/9/23
 * Time: 上午9:10
 */
@Service
public class UserService {

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){

    try{

        return userRepository.findAll();

    }catch (Exception ex) {
        System.out.print("查询失败");
    }
        return null;
    }

    @Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
    public User findUser(Long id){
        System.out.println("无缓存的时候调用这里");
        return userRepository.findById(id);
    }

    public void setUserName(Long id){

        User u = userRepository.findById(id);

        template.opsForValue().set(userNameKey(id),u.getName());
    }

    public String getUserName(Long id){

        return template.opsForValue().get(userNameKey(id));

    }

    public void deleteUserName(Long id){
        template.opsForValue().getOperations().delete(userNameKey(id));
    }


    private String userNameKey(Long id){
        return "user-name-"+String.valueOf(id);
    }
}
