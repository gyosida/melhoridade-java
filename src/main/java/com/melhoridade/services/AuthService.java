package com.melhoridade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melhoridade.data.UserAccountDao;
import com.melhoridade.entities.UserAccount;

@Service
public class AuthService {
	
	@Autowired
	private UserAccountDao userAccountDao;
	
	public UserAccount authenticate(String username, String password) {
		return userAccountDao.findByUsernameAndPassword(username, password);
	}

}
