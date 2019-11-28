package com.treinamento.resource;

import java.io.IOException;
import java.util.List;

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

import com.treinamento.model.Pessoa;
import com.treinamento.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResourse {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<Pessoa>> listar() {
		List<Pessoa> categorias = this.pessoaService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(categorias);
	}

	@GetMapping("{id}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) throws IOException {
		Pessoa pessoa = this.pessoaService.buscarPorId(id);
		if (pessoa == null) {
			throw new RuntimeException();
		}
		return ResponseEntity.status(HttpStatus.OK).body(pessoa);
	}

	@PostMapping
	public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody Pessoa pessoa) throws Exception {
		if (pessoa.getNome() == null || pessoa.getNome().trim() == "") {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		Pessoa novaPessoa = this.pessoaService.cadastrarPessoa(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Pessoa> deletarPessoa(@PathVariable Long id) {
		Pessoa pessoaDeletada = this.pessoaService.deletarPessoa(id);
		if (pessoaDeletada == null) {
			throw new RuntimeException();
		}

		return ResponseEntity.status(HttpStatus.OK).body(pessoaDeletada);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		Pessoa pessoaAtualizada = this.pessoaService.atualizarPessoa(id, pessoa);
		if (pessoaAtualizada == null) {
			throw new RuntimeException();
		}

		return ResponseEntity.status(HttpStatus.OK).body(pessoaAtualizada);
	}

}
