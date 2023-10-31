package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entity.Funcionario;
import com.projetojpa.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public List<Funcionario> buscarTodos(){
		return funcionarioRepository.findAll();
	}
	
	public Funcionario buscarId(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return funcionario.orElse(null);
	}
	
	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public Funcionario alterar(Long id, Funcionario alterarFuncionario) {
		Optional<Funcionario> existe = funcionarioRepository.findById(id);
		if (existe.isPresent()) {
			alterarFuncionario.setId(id);
			return funcionarioRepository.save(alterarFuncionario);
		}
		return null;
	}
	
	public boolean apagar(Long id) {
		Optional<Funcionario> existe = funcionarioRepository.findById(id);
		if(existe.isPresent()) {
			funcionarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
