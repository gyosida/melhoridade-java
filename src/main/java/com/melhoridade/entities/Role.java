package com.melhoridade.entities;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Role implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty(access = Access.READ_WRITE)
	private Long id;
	
	@Enumerated
	private Description description;
	
	public Role() {
		
	}
	
	public Role(Description description) {
		this.description = description;
	}
	
	public enum Description {
		ADMIN("ADMIN"),
		USER("USER"),
		COLABORATOR("COLABORATOR");
		
		private String name;
		
		Description(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	@JsonIgnore
	@Override
	public String getAuthority() {
		return description.toString();
	}

}