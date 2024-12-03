package com.generation.projetointegrador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	
}
