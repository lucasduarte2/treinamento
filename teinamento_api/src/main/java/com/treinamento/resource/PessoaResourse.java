package com.treinamento.resource;

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

import com.treinamento.model.Pessoa;
import com.treinamento.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResourse {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<Pessoa>> listar() {
		List<Pessoa> pessoas = this.pessoaService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(pessoas);
	}

	@GetMapping("{id}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
		Pessoa pessoa = this.pessoaService.buscarPessoaPeloId(id);
		return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();

	}

	@PostMapping
	public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody @Valid Pessoa pessoa) {
		Pessoa novaPessoa = this.pessoaService.cadastrarPessoa(pessoa);
		return novaPessoa != null ? ResponseEntity.ok(novaPessoa) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Pessoa> deletarPessoa(@PathVariable Long id) {
		Pessoa pessoaDeletada = this.pessoaService.deletarPessoa(id);
		return pessoaDeletada != null ? ResponseEntity.ok(pessoaDeletada) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody @Valid Pessoa pessoa) {
		Pessoa pessoaAtualizada = this.pessoaService.atualizarPessoa(id, pessoa);
		return pessoaAtualizada != null ? ResponseEntity.ok(pessoaAtualizada) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}/ativo")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody @Valid Boolean ativo) {
		Pessoa pessoaAtiva = this.pessoaService.atualizarPropriedadeAtivo(id, ativo);
		return pessoaAtiva != null ? ResponseEntity.ok(pessoaAtiva) : ResponseEntity.notFound().build();
	}
	
	

}
