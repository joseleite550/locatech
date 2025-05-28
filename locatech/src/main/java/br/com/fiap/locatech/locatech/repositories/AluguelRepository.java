package br.com.fiap.locatech.locatech.repositories;

import java.util.List;
import java.util.Optional;

import br.com.fiap.locatech.locatech.entities.Aluguel;

public interface AluguelRepository {
	Optional<Aluguel> findById(Long id);
	List<Aluguel> findAll(int size, int offSet);
	Integer save(Aluguel veiculo);
	Integer update(Aluguel veiculo, Long id);
	Integer delete(Long id);
}
