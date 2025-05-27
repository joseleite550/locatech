package br.com.fiap.locatech.locatech.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.locatech.locatech.entities.Pessoa;
import br.com.fiap.locatech.locatech.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);
	
	private final PessoaService pessoaService;
	
	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	
	// http://localhost:8080/pessoas?page=1&size=10
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAllPessoas(@RequestParam("page") int page,
			@RequestParam("size") int size) {
		logger.info("Foi acessado o endpoint de pessoas /pessoas");
		
		var pessoas = this.pessoaService.finAllPessoas(page,size);
		return ResponseEntity.ok(pessoas);
	}
	
	// http://localhost:8080/pessoas/1
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> findPessoa(@PathVariable("id") Long id) {
		logger.info("GET > /pessoas/"+id);
		
		var pessoas = this.pessoaService.findPessoaById(id);
		return ResponseEntity.ok(pessoas);
	}
	
	@PostMapping
	public ResponseEntity<Void> savePessoa(@RequestBody Pessoa pessoa){
		logger.info("POST > /pessoas/");
		this.pessoaService.savePessoa(pessoa);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updatePessoa(@PathVariable("id") Long id,@RequestBody Pessoa pessoa){
		logger.info("PUT > /pessoas/"+id);
		this.pessoaService.updatePessoa(pessoa,id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePessoa(@PathVariable("id") Long id){
		logger.info("DELETE > /pessoas/"+id);
		this.pessoaService.delete(id);
		return ResponseEntity.ok().build();
	}
}
