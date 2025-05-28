package br.com.fiap.locatech.locatech.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import br.com.fiap.locatech.locatech.entities.Aluguel;

@Repository
public class AluguelRepositoryImp  implements AluguelRepository{
	private final JdbcClient jdbcClient;

	public AluguelRepositoryImp(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}
	
	@Override
	public Optional<Aluguel> findById(Long id) {
		return jdbcClient
				.sql("SELECT "
						+ "a.id,a.pessoa_id,a.veiculo_id,a.data_inici,a.data_fim,a.valor_total,"
						+ "p.nome AS pessoa_nome,p.cpf AS pessoa_cpf,"
						+ "v.modelo AS veiculo_modelo,v.placa AS veiculo_placa "
						+ "FROM alugueis a "
						+ "INNER JOIN pessoas p ON a.pessoa_id = p.pessoa_id "
						+ "INNER JOIN veiculo v ON a.veiculo_id = v.id "
						+ "WHERE a.id = :id")
				.param("id",id)
				.query(Aluguel.class)
				.optional();
	}

	@Override
	public List<Aluguel> findAll(int size, int offSet) {
		return jdbcClient
				.sql("SELECT "
						+ "a.id,a.pessoa_id,a.veiculo_id,a.data_inici,a.data_fim,a.valor_total,"
						+ "p.nome AS pessoa_nome,p.cpf AS pessoa_cpf,"
						+ "v.modelo AS veiculo_modelo,v.placa AS veiculo_placa "
						+ "FROM alugueis a "
						+ "INNER JOIN pessoas p ON a.pessoa_id = p.pessoa_id "
						+ "INNER JOIN veiculo v ON a.veiculo_id = v.id "
						+ "LIMIT :size OFFSET :offSet")
				.param("offSet",offSet)
				.param("size",size)
				.query(Aluguel.class)
				.list();
	}

	@Override
	public Integer save(Aluguel aluguel) {
		return jdbcClient
				.sql("INSERT INTO alugueis (pessoa_id,veiculo_id,data_inicio,data_fim,valor_total) VALUES (:pessoa_id,:veiculo_id,:data_inicio,:data_fim,:valor_total)")
				.param("pessoa_id",aluguel.getPessoaId())
				.param("veiculo_id",aluguel.getVeiculoId())
				.param("data_inicio",aluguel.getDataInicio())
				.param("data_fim",aluguel.getDataFim())
				.param("valor_total",aluguel.getValorTotal())
				.update();
	}

	@Override
	public Integer update(Aluguel aluguel, Long id) {
		return jdbcClient
				.sql("UPDATE alugueis SET pessoa_id = :pessoa_id, veiculo_id = :veiculo_id, data_inicio = :data_inicio, data_fim = :data_fim, valor_total = :valor_total WHERE id = :id")
				.param("id",id)
				.param("pessoa_id",aluguel.getPessoaId())
				.param("veiculo_id",aluguel.getVeiculoId())
				.param("data_inicio",aluguel.getDataInicio())
				.param("data_fim",aluguel.getDataFim())
				.param("valor_total",aluguel.getValorTotal())
				.update();
	}

	@Override
	public Integer delete(Long id) {
		return jdbcClient
				.sql("DELETE FROM alugueis WHERE id = :id")
				.param("id",id)
				.update();
	}
}