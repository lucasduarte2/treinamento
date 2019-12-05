package com.money.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.exception.CategoriaNaoEncontradaException;
import com.money.model.Categoria;
import com.money.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> listar() {
		return this.categoriaRepository.findAll();
	}

	public Categoria salvar(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}

	public Categoria buscarPorId(Long codigo) throws CategoriaNaoEncontradaException {
		Optional<Categoria> categoriaEncontrada = this.categoriaRepository.findById(codigo);

		if (categoriaEncontrada.isPresent()) {
			return categoriaEncontrada.get();
		} else {
			throw new CategoriaNaoEncontradaException();
		}
	}

	public void deletar(Long codigo) {
		Optional<Categoria> categoria = this.categoriaRepository.findById(codigo);

		if (categoria.isPresent()) {
			this.categoriaRepository.delete(categoria.get());
		}
	}

	public Categoria atualizar(Long codigo, Categoria categoria) throws CategoriaNaoEncontradaException {
		Optional<Categoria> auxCategoria = this.categoriaRepository.findById(codigo);

		if (auxCategoria.isPresent()) {
			auxCategoria.get().setNome(categoria.getNome());
			return this.categoriaRepository.save(auxCategoria.get());
		} else {
			throw new CategoriaNaoEncontradaException();
		}
	}

}
