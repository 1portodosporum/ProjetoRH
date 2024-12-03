package com.generation.projetointegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.projetointegrador.model.Funcionarios;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long>{
	
	public List<Funcionarios> findAllByNomeContainingIgnoreCase(@Param ("nome") String nome);

}
