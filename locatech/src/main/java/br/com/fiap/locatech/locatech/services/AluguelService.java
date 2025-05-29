package br.com.fiap.locatech.locatech.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.fiap.locatech.locatech.dtos.AluguelRequestDTO;
import br.com.fiap.locatech.locatech.entities.Aluguel;
import br.com.fiap.locatech.locatech.repositories.AluguelRepository;
import br.com.fiap.locatech.locatech.repositories.VeiculoRepository;
import br.com.fiap.locatech.locatech.services.exceptions.ResourceNotFoundException;

@Service
public class AluguelService {
private final AluguelRepository alguelRepository;
private final VeiculoRepository veiculoRepository;
	
	public AluguelService(AluguelRepository aluguelRepository,VeiculoRepository veiculoRepository) {
		this.alguelRepository = aluguelRepository;
		this.veiculoRepository = veiculoRepository;
	}
	
	public List<Aluguel> finAllAluguels(int page,int size){
		int offSet = (page -1)*size;
		return alguelRepository.findAll(size, offSet);
	}
	
	public Optional<Aluguel> findAluguelById(Long id){
		return Optional.ofNullable(alguelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Aluguel não encontrado")));
	}
	
	public void saveAluguel(AluguelRequestDTO aluguel) {
		var aluguelEntity = calculaAluguel(aluguel);
		var save = alguelRepository.save(aluguelEntity);
		Assert.state(save ==1, "erro ao salvar alguel " + aluguelEntity.getPessoaId());
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

	private Aluguel calculaAluguel(AluguelRequestDTO aluquelRequestDTO) {
		var veiculo = this.veiculoRepository.findById(aluquelRequestDTO.veiculoId()).orElseThrow(()->new RuntimeException("Veículo não encontrado"));
		
		var quantidadeDias = BigDecimal.valueOf(aluquelRequestDTO.dataFim().getDayOfYear() - aluquelRequestDTO.dataInicio().getDayOfYear());
		var valor = veiculo.getValorDiaria().multiply(quantidadeDias);
		
		return new Aluguel(aluquelRequestDTO,valor);
		
	}
}