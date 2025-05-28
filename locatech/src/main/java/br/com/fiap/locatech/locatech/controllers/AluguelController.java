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

import br.com.fiap.locatech.locatech.entities.Aluguel;
import br.com.fiap.locatech.locatech.services.AluguelService;


@RestController
@RequestMapping("/alugueis")
public class AluguelController {

	private static final Logger logger = LoggerFactory.getLogger(AluguelController.class);
	
	private final AluguelService aluguelService;
	
	public AluguelController(AluguelService aluguelService) {
		this.aluguelService = aluguelService;
	}
	
	
	// http://localhost:8080/aluguels?page=1&size=10
	@GetMapping
	public ResponseEntity<List<Aluguel>> findAllAluguels(@RequestParam("page") int page,
			@RequestParam("size") int size) {
		logger.info("Foi acessado o endpoint de aluguels /aluguels");
		
		var aluguels = this.aluguelService.finAllAluguels(page,size);
		return ResponseEntity.ok(aluguels);
	}
	
	// http://localhost:8080/aluguels/1
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Aluguel>> findAluguel(@PathVariable("id") Long id) {
		logger.info("GET > /aluguels/"+id);
		
		var aluguels = this.aluguelService.findAluguelById(id);
		return ResponseEntity.ok(aluguels);
	}
	
	@PostMapping
	public ResponseEntity<Void> saveAluguel(@RequestBody Aluguel aluguel){
		logger.info("POST > /aluguels/");
		this.aluguelService.saveAluguel(aluguel);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateAluguel(@PathVariable("id") Long id,@RequestBody Aluguel aluguel){
		logger.info("PUT > /aluguels/"+id);
		this.aluguelService.updateAluguel(aluguel,id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAluguel(@PathVariable("id") Long id){
		logger.info("DELETE > /aluguels/"+id);
		this.aluguelService.delete(id);
		return ResponseEntity.ok().build();
	}
}