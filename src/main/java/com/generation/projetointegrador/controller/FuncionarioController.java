package com.generation.projetointegrador.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.projetointegrador.model.Funcionarios;
import com.generation.projetointegrador.repository.DepartamentosRepository;
import com.generation.projetointegrador.repository.FuncionariosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioController {
	
	@Autowired
	private FuncionariosRepository funcionarioRepository;

	@Autowired
	private DepartamentosRepository departamentosRespository;
	
	@GetMapping
	public ResponseEntity<List<Funcionarios>> getAll(){
		return ResponseEntity.ok(funcionarioRepository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionarios>getById(@PathVariable Long id){
		return funcionarioRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Funcionarios>> getBynome(@PathVariable String nome){
		return ResponseEntity.ok(funcionarioRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Funcionarios>post(@Valid @RequestBody Funcionarios funcionarios){
		if (departamentosRespository.existsById(funcionarios.getDepartamento().getId()))
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(funcionarioRepository.save(funcionarios));
		
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Departamento não existe", null);
	}
	
	@PutMapping
	public ResponseEntity<Funcionarios> put(@Valid @RequestBody Funcionarios funcionarios){
		if(funcionarioRepository.existsById(funcionarios.getId())) {
			if(departamentosRespository.existsById(funcionarios.getDepartamento().getId()))
				return ResponseEntity.status(HttpStatus.OK)
						.body(funcionarioRepository.save(funcionarios));
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Departamento não existe!", null);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		Optional<Funcionarios> funcionarios = funcionarioRepository.findById(id);
		
		if(funcionarios.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		funcionarioRepository.deleteById(id);
	}
}
