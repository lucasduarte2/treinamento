package com.treinamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.error.ResourceNotFoundException;
import com.treinamento.model.Categoria;
import com.treinamento.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> listar() {
		return this.categoriaRepository.findAll();
	}
	
	public Optional<Categoria> buscarPorId(Long id) {
		return this.categoriaRepository.findById(id);
	}

	public  Categoria cadastrarCategoria(Categoria categoria) {
		if(categoria == null) {
			throw new ResourceNotFoundException("Error");
		}
		return this.categoriaRepository.save(categoria);
	}

	public Categoria deletarCategoria(Long id) {
		Optional<Categoria> categoriaNoBanco = this.categoriaRepository.findById(id);
		if(categoriaNoBanco.isPresent()) {
			this.categoriaRepository.delete(categoriaNoBanco.get());
			return categoriaNoBanco.get();
		}
		return categoriaNoBanco.get();
	}
	
	public Categoria atualizarCategoria(Long id, Categoria categoria) {
		Optional<Categoria> categoriaNoBanco = this.categoriaRepository.findById(id);
		if(categoriaNoBanco.isPresent()) {
			categoria.setCodigo(categoriaNoBanco.get().getCodigo());
			return this.categoriaRepository.save(categoria);
		}
		
		return categoriaNoBanco.get();
	}

}
