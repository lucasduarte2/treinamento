package com.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
