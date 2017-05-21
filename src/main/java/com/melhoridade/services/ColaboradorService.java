package com.melhoridade.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.melhoridade.entities.Colaborador;

@Service
public class ColaboradorService {

	List<Colaborador> colaboradores = new ArrayList(Arrays.asList(
			new Colaborador("id1","colaborador 1"),
			new Colaborador("id2","colaborador 2"),
			new Colaborador("id3","colaborador 3"),
			new Colaborador("id4","colaborador 4")
			));
	
	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}
	
	public Colaborador getColaborador(String id) {
		return colaboradores.stream()
				.filter(c -> c.getId().equals(id))
				.findFirst()
				.get();
	}
	
	public Colaborador agregarColaborador(Colaborador colaborador) {
		colaborador.setId("id" + (colaboradores.size() + 1));
		colaboradores.add(colaborador);
		return colaborador;
	}
	
}
