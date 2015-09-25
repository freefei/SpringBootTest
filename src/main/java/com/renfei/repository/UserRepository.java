package com.renfei.repository;

import com.renfei.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * User的JPA Repository
 *
 * @author songrenfei
 * @version 1.0.0
 */
public interface UserRepository extends JpaRepository<User,String>{

    public User findById(Long id);
	
}