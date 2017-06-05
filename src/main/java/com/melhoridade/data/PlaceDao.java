package com.melhoridade.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.melhoridade.entities.Place;

public interface PlaceDao extends CrudRepository<Place, Long>{

	List<Place> findByColaboratorId(Long colaboratorId);
	
}
