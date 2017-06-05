package com.melhoridade.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.melhoridade.entities.User;
import com.melhoridade.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public User addUser(@RequestBody User usuario) {
		return userService.addUser(usuario);
	}
	
	@GetMapping("/users/all")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/users/profile")
	public User getUserProfile() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return userService.getUser(username);
	}
	
}
