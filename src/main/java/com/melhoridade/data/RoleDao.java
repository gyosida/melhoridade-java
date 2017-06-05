package com.melhoridade.data;

import org.springframework.data.repository.CrudRepository;

import com.melhoridade.entities.Role;
import com.melhoridade.entities.Role.Description;

public interface RoleDao extends CrudRepository<Role, Long> {
	
	Role findByDescription(Description description);

}