package com.treinamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.model.Categoria;
import com.treinamento.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResourse {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {
		List<Categoria> categorias = this.categoriaService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(categorias);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
		Optional<Categoria> categoria = this.categoriaService.buscarPorId(id);
		if(categoria == null) {
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return   ResponseEntity.status(HttpStatus.OK).body(categoria.get());
	}

	@PostMapping
	public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody Categoria categoria) {
		Categoria novaCategoria = this.categoriaService.cadastrarCategoria(categoria);
		if(novaCategoria == null) {
			return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Categoria> deletarCategoria(@PathVariable Long id) {
		Categoria categoriaDeletada = this.categoriaService.deletarCategoria(id);
		if(categoriaDeletada == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		return  ResponseEntity.status(HttpStatus.OK).body(categoriaDeletada);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id,@RequestBody Categoria categoria) {
		Categoria categoriaAtualizada = this.categoriaService.atualizarCategoria(id, categoria);
		if(categoriaAtualizada == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		return  ResponseEntity.status(HttpStatus.OK).body(categoria);
	}

}
