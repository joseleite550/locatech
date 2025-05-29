package br.com.fiap.locatech.locatech.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record AluguelRequestDTO(
		@NotNull(message = "O id da pessoa não pode ser nulo")
		Long pessoaId,
		@NotNull(message = "O id do veiculo não pode ser nulo")
		Long veiculoId,
		LocalDate dataInicio,
		LocalDate dataFim) {

}
