package com.project.banco.model.dto;

import javax.validation.constraints.NotNull;

public class ClienteDTO {
	
	@NotNull
	private ContaDTO conta;
	
	@NotNull
	private String nome;
	
	@NotNull
	private Long cpf;
	
	public ClienteDTO(String nome, Long cpf, ContaDTO conta) {
		
		this.nome = nome;
		this.conta = conta;
		this.cpf = cpf;
		
	}

	
	public ContaDTO getConta() {
		return conta;
	}
	
	public void setConta(ContaDTO conta) {
		this.conta = conta;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getCpf() {
		return cpf;
	}
	
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

}
