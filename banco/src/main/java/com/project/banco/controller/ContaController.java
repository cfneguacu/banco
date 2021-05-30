package com.project.banco.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.project.banco.model.dto.ContaDTO;

@RestController
@RequestMapping(value = "/conta")

public class ContaController {
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContaDTO> save(@Valid @RequestBody ContaDTO dto){
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContaDTO> update(@Valid @RequestBody ContaDTO dto){
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ContaDTO>> findAll(){
		List<ContaDTO> list = new ArrayList<>();
		ContaDTO conta1 = new ContaDTO(1,1,1357,200.00);
		list.add(conta1);
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping(value = "/{numconta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContaDTO> findById(@PathVariable Integer numconta){
		List<ContaDTO> list = new ArrayList<>();
		ContaDTO conta1 = new ContaDTO(1,1,1357,200.00);
		ContaDTO conta2 = new ContaDTO(1,2,1357,200.00);
		list.add(conta1);
		list.add(conta2);
		ContaDTO dtoSelect = list.stream().filter(x -> x.getNumeroDaConta().compareTo(numconta)==0).findFirst().get();
		return  ResponseEntity.ok(dtoSelect);
	}
}
