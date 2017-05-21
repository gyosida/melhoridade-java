package com.melhoridade.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.melhoridade.entities.Colaborador;
import com.melhoridade.services.ColaboradorService;

@RestController
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService colaboradorService;

	@GetMapping("/colaboradores")
	public List<Colaborador> getColaboradores() {
		return colaboradorService.getColaboradores();
	}
	
	@GetMapping("/colaboradores/{id}")
	public Colaborador getColaborador(@PathVariable String id) {
		return colaboradorService.getColaborador(id);
	}
	
	@PostMapping("/colaboradores")
	public Colaborador agregarColaborador(@RequestBody Colaborador colaborador) {
		return colaboradorService.agregarColaborador(colaborador);
	}
	
}
