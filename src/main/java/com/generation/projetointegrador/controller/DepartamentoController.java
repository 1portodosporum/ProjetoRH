package com.generation.projetointegrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.generation.projetointegrador.model.Departamentos;
import com.generation.projetointegrador.model.Funcionarios;
import com.generation.projetointegrador.repository.DepartamentosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departamentos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartamentoController {

	@Autowired
	private DepartamentosRepository departamentoRepository;

	@GetMapping
	public ResponseEntity<List<Departamentos>> getAll() {
		return ResponseEntity.ok(departamentoRepository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamentos> getById(@PathVariable Long id) {
		return departamentoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Departamentos>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(departamentoRepository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<Departamentos> post(@Valid @RequestBody Departamentos departamentos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoRepository.save(departamentos));

	}

	@PutMapping
	public ResponseEntity<Departamentos> put(@Valid @RequestBody Departamentos departamentos) {
		return ResponseEntity.status(HttpStatus.OK).body(departamentoRepository.save(departamentos));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Optional<Departamentos> departamentos =departamentoRepository.findById(id);

        if(departamentos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        departamentoRepository.deleteById(id);
    }
}
