package com.melhoridade.data;

import org.springframework.data.repository.CrudRepository;

import com.melhoridade.entities.Colaborator;

public interface ColaboratorDao extends CrudRepository<Colaborator, Long> {

}
