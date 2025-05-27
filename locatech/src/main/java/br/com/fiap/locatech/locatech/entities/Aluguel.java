package br.com.fiap.locatech.locatech.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

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
}
