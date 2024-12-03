package com.generation.projetointegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_funcionarios")
public class Funcionarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome é obrigatório")
	@Size(min = 3, max = 70, message = "O nome deve conter pelo menos 3 letras e o máximo de 70 caracteres")
	private String nome;
	
	@NotBlank(message = "O salário é obrigatório")
	private Float salario;
	
	@NotBlank(message = "A data de admissão é obrigatório")
	private String data_admissao;
	
	@NotBlank(message = "O cargo é obrigatório")
	private String cargo;
	
	@ManyToOne
	@JsonIgnoreProperties("Funcionarios")
	private Departamentos departamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public String getData_admissao() {
		return data_admissao;
	}

	public void setData_admissao(String data_admissao) {
		this.data_admissao = data_admissao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Departamentos getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamentos departamento) {
		this.departamento = departamento;
	}

	
	
	
	
}
