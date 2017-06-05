package com.melhoridade.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melhoridade.data.ColaboratorDao;
import com.melhoridade.entities.Colaborator;
import com.melhoridade.entities.Role;
import com.melhoridade.entities.Role.Description;

@Service
public class ColaboradorService extends RoleService {

	@Autowired
	private ColaboratorDao colaboratorDao;
	
	public List<Colaborator> getColaboradores() {
		List<Colaborator> colaborators = new ArrayList<>();
		colaboratorDao.findAll().forEach(colaborators::add);
		return colaborators;
	}
	
	public Colaborator getColaborator(Long id) {
		return colaboratorDao.findOne(id);
	}
	
	public Colaborator agregarColaborador(Colaborator colaborator) {
		Role role = roleDao.findByDescription(Description.COLABORATOR);
		colaborator.setRole(role);
		return colaboratorDao.save(colaborator);
	}
	
	public void atualizarColaborador(Long id, Colaborator colaborator) {
		if (id == null) {
			// TODO thrown appropriate exception
			throw new IllegalArgumentException("precisa-se de o id do colaborador");
		}
		colaborator.setId(id);
		colaboratorDao.save(colaborator);
	}
	
	public void excluirColaborador(Long id) {
		colaboratorDao.delete(id);
	}
	
}