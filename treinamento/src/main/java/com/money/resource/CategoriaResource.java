package com.money.resource;

import java.util.List;

import javax.validation.Valid;

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

import com.money.exception.CategoriaNaoEncontradaException;
import com.money.model.Categoria;
import com.money.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	public ResponseEntity<Categoria> criar(@RequestBody @Valid Categoria categoria) {
		Categoria novaCategoria = this.categoriaService.salvar(categoria);
		return ResponseEntity.status(HttpStatus.OK).body(novaCategoria);
	}

	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {
		List<Categoria> categoriasEncontradas = this.categoriaService.listar();

		if (categoriasEncontradas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(categoriasEncontradas);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long codigo) throws CategoriaNaoEncontradaException {
		Categoria categoriaEncontrada = this.categoriaService.buscarPorId(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(categoriaEncontrada);
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Categoria> deletarCategoria(@PathVariable("codigo") Long codigo) {
		this.categoriaService.deletar(codigo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Categoria> atualizar(@PathVariable Long codigo, @RequestBody @Valid Categoria categoria)
			throws CategoriaNaoEncontradaException {
		Categoria categoriaAtualizada = this.categoriaService.atualizar(codigo, categoria);
		return ResponseEntity.status(HttpStatus.OK).body(categoriaAtualizada);
	}

}
