package com.melhoridade.data;

import org.springframework.data.repository.CrudRepository;

import com.melhoridade.entities.UserAccount;

public interface UserAccountDao extends CrudRepository<UserAccount, Integer> {

	UserAccount findByUsernameAndPassword(String username, String password);
	
}
