package br.com.fiap.locatech.locatech.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fiap.locatech.locatech.dtos.AluguelRequestDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Aluguel {
	private long id;
	private long pessoaId;
	private long veiculoId;
	private String modeloVeiculo;
	private String pessoaCpf;
	private String pessoaNome;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private BigDecimal valorTotal;
	
	
	public Aluguel(AluguelRequestDTO aluguelRequestDTO,BigDecimal valorTotal) {
		this.pessoaId = aluguelRequestDTO.pessoaId();
		this.veiculoId = aluguelRequestDTO.veiculoId();
		this.dataInicio = aluguelRequestDTO.dataInicio();
		this.dataFim = aluguelRequestDTO.dataFim();
		this.valorTotal =  valorTotal;
	}
}
