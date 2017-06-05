package com.melhoridade.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melhoridade.data.RoleDao;
import com.melhoridade.data.UserDao;
import com.melhoridade.entities.Role;
import com.melhoridade.entities.Role.Description;
import com.melhoridade.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;

	public User addUser(User user) {
		Role role = roleDao.findByDescription(Description.USER);
		user.setRole(role);
		return userDao.save(user);
	}
	
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		userDao.findAll().forEach(users::add);
		return users;
	}
	
	public User getUser(String username) {
		return userDao.findByUsername(username);
	}
	
}