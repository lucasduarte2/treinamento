package com.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
