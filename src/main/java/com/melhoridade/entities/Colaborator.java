package com.melhoridade.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Colaborator extends UserAccount {
	
	private static final long serialVersionUID = 1L;
	
	//TODO define properties
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "colaborator")
	private Set<Place> places;

	public Set<Place> getPlaces() {
		return places;
	}

	public void setPlaces(Set<Place> places) {
		this.places = places;
	}

}