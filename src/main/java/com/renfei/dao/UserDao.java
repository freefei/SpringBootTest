package com.renfei.dao;

import com.renfei.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/9/8
 * Time: 下午3:59
 */
@Transactional
public interface UserDao extends CrudRepository<User, Long> {
    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     */
    public User findByEmail(String email);
}
