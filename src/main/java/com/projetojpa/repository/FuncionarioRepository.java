package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
