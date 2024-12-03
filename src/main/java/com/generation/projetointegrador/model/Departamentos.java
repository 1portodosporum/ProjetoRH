package com.generation.projetointegrador.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "tb_departamentos")
public class Departamentos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome é obrigatório")
	@Size(min = 2, max = 30, message = "O departamento deve conter pelo menos 2 letras e o máximo de 30 caracteres")
	private String nome_departamento;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("funcionario")
	private List<Funcionarios> funcionario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_departamento() {
		return nome_departamento;
	}

	public void setNome_departamento(String nome_departamento) {
		this.nome_departamento = nome_departamento;
	}

	public List<Funcionarios> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionarios> funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	
}
