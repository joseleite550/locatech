package br.com.fiap.locatech.locatech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.fiap.locatech.locatech.entities.Aluguel;
import br.com.fiap.locatech.locatech.repositories.AluguelRepository;

@Service
public class AluguelService {
private final AluguelRepository alguelRepository;
	
	public AluguelService(AluguelRepository alguelRepository) {
		this.alguelRepository = alguelRepository;
	}
	
	public List<Aluguel> finAllAluguels(int page,int size){
		int offSet = (page -1)*size;
		return alguelRepository.findAll(size, offSet);
	}
	
	public Optional<Aluguel> findAluguelById(Long id){
		return alguelRepository.findById(id);
	}
	
	public void saveAluguel(Aluguel alguel) {
		var save = alguelRepository.save(alguel);
		Assert.state(save ==1, "erro ao salvar alguel " + alguel.getPessoaId());
	}
	
	public void updateAluguel(Aluguel alguel,Long id) {
		var update = alguelRepository.update(alguel, id);
		if(update==0) {
			throw new RuntimeException("Veículo não encontrado");
		}
	}
	
	public void delete(Long id) {
		var delete = alguelRepository.delete(id);
		if(delete==0) {
			throw new RuntimeException("Veículo não encontrado");
		}
		
	}
}