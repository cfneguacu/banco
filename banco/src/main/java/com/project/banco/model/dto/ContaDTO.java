package com.project.banco.model.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class ContaDTO {
	
	@NotNull
	private Integer agencia;
	
	private Integer numConta;
	
	@NotNull
	private Integer senha;
	
	@NotNull
	@DecimalMin(value="0.00")
	@Digits(integer = 6, fraction = 2)
	private Double saldo;

	public ContaDTO(Integer agencia, Integer numConta, Integer senha, Double saldo) {
		
		this.agencia = agencia;
		this.numConta = numConta;
		this.senha = senha;
		this.saldo = saldo;
	}

	public Integer getAgenciaBancaria() {
		return agencia;
	}
	
	public void setAgenciaBancaria(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumeroDaConta() {
		return numConta;
	}
	
	public void setNumeroDaConta(Integer numConta) {
		this.numConta = numConta;
	}
	
	public Integer getSenha(){
		return senha;
	}
	
	public void setSenha(Integer senha) {
		this.senha = senha;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
