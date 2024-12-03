package com.generation.projetointegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.projetointegrador.model.Departamentos;

public interface DepartamentosRepository extends JpaRepository<Departamentos, Long> {

	public List<Departamentos> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	
}
