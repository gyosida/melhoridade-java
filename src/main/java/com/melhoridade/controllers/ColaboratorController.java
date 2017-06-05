package com.melhoridade.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.melhoridade.entities.Colaborator;
import com.melhoridade.entities.Place;
import com.melhoridade.services.ColaboradorService;
import com.melhoridade.services.PlaceService;

@RestController
public class ColaboratorController {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@Autowired
	private PlaceService placeService;

	@GetMapping("/colaborators")
	public List<Colaborator> getColaborators() {
		return colaboradorService.getColaboradores();
	}
	
	@GetMapping("/colaborators/{id}")
	public Colaborator getColaborator(@PathVariable Long id) {
		return colaboradorService.getColaborator(id);
	}
	
	@PostMapping("/colaborators")
	public Colaborator addColaborator(@RequestBody Colaborator colaborador) {
		return colaboradorService.agregarColaborador(colaborador);
	}
	
	@PutMapping("/colaborators/{id}")
	public void updateColaborator(@PathVariable Long id, @RequestBody Colaborator colaborador) {
		colaboradorService.atualizarColaborador(id, colaborador);
	}
	
	@DeleteMapping("colaborators/{id}")
	public void deleteColaborator(@PathVariable Long id) {
		colaboradorService.excluirColaborador(id);
	}
	
	@PostMapping("/colaborators/{colaboratorId}/places")
	public Place savePlace(@PathVariable Long colaboratorId, @RequestBody Place place) {
		return placeService.savePlace(colaboratorId, place);
	}
	
	@GetMapping("/colaborators/{colaboratorId}/places")
	public List<Place> getColaboratorPlaces(@PathVariable Long colaboratorId) {
		return placeService.getPlacesFromColaborator(colaboratorId);
	}
	
}