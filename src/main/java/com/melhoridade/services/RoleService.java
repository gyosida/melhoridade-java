package com.melhoridade.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.melhoridade.data.RoleDao;

public abstract class RoleService {

	@Autowired
	protected RoleDao roleDao;
	
}