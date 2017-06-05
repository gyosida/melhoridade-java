package com.melhoridade.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melhoridade.data.PlaceDao;
import com.melhoridade.entities.Colaborator;
import com.melhoridade.entities.Place;

@Service
public class PlaceService {
	
	@Autowired
	private PlaceDao placeDao;
	
	public Place savePlace(Long colaboratorId, Place place) {
		Colaborator colaborator = new Colaborator();
		colaborator.setId(colaboratorId);
		place.setColaborator(colaborator);
		return placeDao.save(place);
	}
	
	public List<Place> getPlacesFromColaborator(Long colaboratorId) {
		List<Place> places = new ArrayList();
		placeDao.findByColaboratorId(colaboratorId).forEach(places::add);
		return places;
	}

}