package com.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.money.model.Lancamento;

public interface LancamentoRepository  extends JpaRepository<Lancamento, Long> {

}
