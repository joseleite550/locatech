package br.com.fiap.locatech.locatech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.fiap.locatech.locatech.entities.Pessoa;
import br.com.fiap.locatech.locatech.repositories.PessoaRepository;

@Service
public class PessoaService {
private final PessoaRepository pessoaRepository;
	
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	public List<Pessoa> finAllPessoas(int page,int size){
		int offSet = (page -1)*size;
		return pessoaRepository.findAll(size, offSet);
	}
	
	public Optional<Pessoa> findPessoaById(Long id){
		return pessoaRepository.findById(id);
	}
	
	public void savePessoa(Pessoa pessoa) {
		var save = pessoaRepository.save(pessoa);
		Assert.state(save ==1, "erro ao salvar pessoa " + pessoa.getNome());
	}
	
	public void updatePessoa(Pessoa pessoa,Long id) {
		var update = pessoaRepository.update(pessoa, id);
		if(update==0) {
			throw new RuntimeException("Veículo não encontrado");
		}
	}
	
	public void delete(Long id) {
		var delete = pessoaRepository.delete(id);
		if(delete==0) {
			throw new RuntimeException("Veículo não encontrado");
		}
		
	}
}
