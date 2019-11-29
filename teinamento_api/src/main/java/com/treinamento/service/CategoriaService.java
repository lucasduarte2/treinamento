package com.treinamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.treinamento.model.Categoria;
import com.treinamento.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> listar() {
		return this.categoriaRepository.findAll();
	}

	public Categoria buscarCategoriaPorId(Long id) {
		return this.categoriaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	public Categoria cadastrarCategoria(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}

	public Categoria deletarCategoria(Long id) {
		Categoria categoriaSalva = buscarCategoriaPorId(id);
		this.categoriaRepository.delete(categoriaSalva);
		return categoriaSalva;
	}

	public Categoria atualizarCategoria(Long id, Categoria categoria) {
		Categoria categoriaSalva = buscarCategoriaPorId(id);
		categoriaSalva.setNome(categoria.getNome());
		return this.categoriaRepository.save(categoriaSalva);
	}

}