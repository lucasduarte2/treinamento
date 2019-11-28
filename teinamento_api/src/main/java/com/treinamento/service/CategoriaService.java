package com.treinamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	public Categoria buscarPorId(Long id) {
		Optional<Categoria> categoriaNoBanco = this.categoriaRepository.findById(id);
		if (categoriaNoBanco.isPresent()) {
			return categoriaNoBanco.get();
		}
		return null;
	}

	public Categoria cadastrarCategoria(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}

	public Categoria deletarCategoria(Long id) {
		Optional<Categoria> categoriaNoBanco = this.categoriaRepository.findById(id);
		if (categoriaNoBanco.isPresent()) {
			this.categoriaRepository.delete(categoriaNoBanco.get());
			return categoriaNoBanco.get();
		}
		return null;
	}

	public Categoria atualizarCategoria(Long id, Categoria categoria) {
		Optional<Categoria> categoriaNoBanco = this.categoriaRepository.findById(id);
		if (categoriaNoBanco.isPresent()) {
			categoria.setCodigo(categoriaNoBanco.get().getCodigo());
			return this.categoriaRepository.save(categoria);
		}

		return null;
	}

}