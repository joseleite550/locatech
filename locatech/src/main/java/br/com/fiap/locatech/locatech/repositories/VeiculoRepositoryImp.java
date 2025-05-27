package br.com.fiap.locatech.locatech.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import br.com.fiap.locatech.locatech.entities.Veiculo;

@Repository
public class VeiculoRepositoryImp implements VeiculoRepository{

	private final JdbcClient jdbcClient;
	
	public VeiculoRepositoryImp(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}
	
	@Override
	public Optional<Veiculo> findById(Long id) {
		return jdbcClient
				.sql("SELECT * FROM veiculos WHERE id = :id")
				.param("id",id)
				.query(Veiculo.class)
				.optional();
	}

	@Override
	public List<Veiculo> findAll(int size, int offSet) {
		return jdbcClient
				.sql("SELECT * FROM veiculos LIMIT :size OFFSET :offSet")
				.param("offSet",offSet)
				.param("size",size)
				.query(Veiculo.class)
				.list();
	}

	@Override
	public Integer save(Veiculo veiculo) {
		return jdbcClient
				.sql("INSERT INTO veiculos (marca,modelo,placa,ano,cor,valor_diaria) VALUES (:marca,:modelo,:placa,:ano,:cor,:valor_diaria)")
				.param("marca",veiculo.getMarca())
				.param("modelo",veiculo.getModelo())
				.param("placa",veiculo.getPlaca())
				.param("ano",veiculo.getAno())
				.param("cor",veiculo.getCor())
				.param("valor_diaria",veiculo.getValorDiaria())
				.update();
	}

	@Override
	public Integer update(Veiculo veiculo, Long id) {
		return jdbcClient
				.sql("UPDATE veiculos SET marca = :marca, modelo = :modelo, placa = :placa, ano = :ano,cor = :cor, valor_diaria = :valor_diaria WHERE id = :id")
				.param("id",id)
				.param("marca",veiculo.getMarca())
				.param("modelo",veiculo.getModelo())
				.param("placa",veiculo.getPlaca())
				.param("ano",veiculo.getAno())
				.param("cor",veiculo.getCor())
				.param("valor_diaria",veiculo.getValorDiaria())
				.update();
	}

	@Override
	public Integer delete(Long id) {
		return jdbcClient
				.sql("DELETE FROM veiculos WHERE id = :id")
				.param("id",id)
				.update();
	}

}
