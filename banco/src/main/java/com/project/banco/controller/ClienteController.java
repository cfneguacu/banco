package com.project.banco.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.banco.model.dto.ClienteDTO;
import com.project.banco.model.dto.ContaDTO;

@RestController
@RequestMapping(value = "/cliente")

public class ClienteController {
	
	Random random = new Random();
	String nome = "Claudio";
	Long cpf = 2932598235L;
	Integer senha = 12365;
	Integer numConta = random.nextInt(4000)+1000;
	Integer Agencia = random.nextInt(4000)+1000;
	double saldo = random.nextInt(999999)/10;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> save(@Valid @RequestBody ClienteDTO cliente){
		return ResponseEntity.ok(cliente);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> update(@Valid @RequestBody ClienteDTO cliente){
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClienteDTO>> findAll(){
		List<ClienteDTO> list = new ArrayList<>();
		ClienteDTO cliente = new ClienteDTO(nome, cpf, new ContaDTO(Agencia, numConta, senha, saldo));
		list.add(cliente);
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> findById(@PathVariable Long id){
		List<ClienteDTO> list = new ArrayList<>();
		ClienteDTO cliente1 = new ClienteDTO(nome, cpf, new ContaDTO(Agencia, numConta, senha, saldo));
		ClienteDTO cliente2 = new ClienteDTO(nome, cpf, new ContaDTO(Agencia, numConta, senha, saldo));
		list.add(cliente1);
		list.add(cliente2);
		ClienteDTO clienteSelect = list.stream().filter(x -> x.getCpf().compareTo(id)==0).findFirst().get();
		return  ResponseEntity.ok(clienteSelect);
	}

}