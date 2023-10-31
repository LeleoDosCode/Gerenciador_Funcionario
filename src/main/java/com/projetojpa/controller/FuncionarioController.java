package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entity.Funcionario;
import com.projetojpa.service.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "funcionario", description = "API REST  DE GERENCIAMENTO DE DADOS")
@RestController
@RequestMapping("/funcionario")

public class FuncionarioController {
	
	private final FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	@GetMapping("/(id)")
	@Operation(summary = "Localiza funcionario por ID")
	public ResponseEntity<Funcionario> bsucarId(@PathVariable Long id){
		Funcionario funcionario = funcionarioService.buscarId(id);
		if(funcionario != null) {
			return ResponseEntity.ok(funcionario);
		}
		else {
			return ResponseEntity.notFound().build();	
		}
	}
	
	@GetMapping("/")
	@Operation(summary = "Apresenta todos os funcionarios")
	public ResponseEntity<List<Funcionario>> buscarTodos(){
		List<Funcionario> funcionarios = funcionarioService.buscarTodos();
		return ResponseEntity.ok(funcionarios);
	}
	
	@PostMapping("/")
	@Operation(summary = "Inserindo dados")
	public ResponseEntity<Funcionario> salvar(@RequestBody @Valid Funcionario funcionario){
		Funcionario salvar = funcionarioService.salvar(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
	}
}
