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

import br.com.fiap.locatech.locatech.entities.Veiculo;
import br.com.fiap.locatech.locatech.services.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	private static final Logger logger = LoggerFactory.getLogger(VeiculoController.class);
	
	private final VeiculoService veiculoService;
	
	public VeiculoController(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}
	
	
	// http://localhost:8080/veiculos?page=1&size=10
	@GetMapping
	public ResponseEntity<List<Veiculo>> findAllVeiculos(@RequestParam("page") int page,
			@RequestParam("size") int size) {
		logger.info("Foi acessado o endpoint de veiculos /veiculos");
		
		var veiculos = this.veiculoService.finAllVeiculos(page,size);
		return ResponseEntity.ok(veiculos);
	}
	
	// http://localhost:8080/veiculos/1
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Veiculo>> findVeiculo(@PathVariable("id") Long id) {
		logger.info("GET > /veiculos/"+id);
		
		var veiculos = this.veiculoService.findVeiculoById(id);
		return ResponseEntity.ok(veiculos);
	}
	
	@PostMapping
	public ResponseEntity<Void> saveVeiculo(@RequestBody Veiculo veiculo){
		logger.info("POST > /veiculos/");
		this.veiculoService.saveVeiculo(veiculo);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateVeiculo(@PathVariable("id") Long id,@RequestBody Veiculo veiculo){
		logger.info("PUT > /veiculos/"+id);
		this.veiculoService.updateVeiculo(veiculo,id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVeiculo(@PathVariable("id") Long id){
		logger.info("DELETE > /veiculos/"+id);
		this.veiculoService.delete(id);
		return ResponseEntity.ok().build();
	}
} 
