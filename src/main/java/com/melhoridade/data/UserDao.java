package com.melhoridade.data;

import org.springframework.data.repository.CrudRepository;

import com.melhoridade.entities.User;

public interface UserDao extends CrudRepository<User, Long> {

	User findByUsername(String username);
	
}
