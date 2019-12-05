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

import com.money.model.Pessoa;
import com.money.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;

	@PostMapping
	public ResponseEntity<Pessoa> criar(@RequestBody @Valid Pessoa pessoa) {
		Pessoa pessoaSalva = this.pessoaService.salvar(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}

	@GetMapping
	public ResponseEntity<List<Pessoa>> listar() {
		List<Pessoa> pessoasEncontradas = this.pessoaService.listar();
		return !pessoasEncontradas.isEmpty() ? ResponseEntity.ok(pessoasEncontradas)
				: ResponseEntity.noContent().build();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long codigo) {
		Pessoa pessoa = this.pessoaService.buscarPessoaPeloId(codigo);
		return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Pessoa> remover(@PathVariable Long codigo) {
		Pessoa pessoaDeletada = this.pessoaService.remover(codigo);
		return pessoaDeletada != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo, @RequestBody @Valid Pessoa pessoa) {
		Pessoa pessoaAtualizada = this.pessoaService.atualizar(codigo, pessoa);
		return pessoaAtualizada != null ? ResponseEntity.ok(pessoaAtualizada) : ResponseEntity.notFound().build();
	}

	// Verificar aqui
	@PutMapping("/{codigo}/ativo")
	public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
		this.pessoaService.atualizarPropriedadeAtivo(codigo, ativo);
	}

}
