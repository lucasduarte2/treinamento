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

import com.money.model.Lancamento;
import com.money.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;

	@PostMapping
	public ResponseEntity<Lancamento> criar(@RequestBody @Valid Lancamento lancamento) {
		Lancamento lancamentoSalvo = this.lancamentoService.salvar(lancamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}

	@GetMapping
	public ResponseEntity<List<Lancamento>> listar() {
		List<Lancamento> lancamentosEncontrados = this.lancamentoService.listar();
		return !lancamentosEncontrados.isEmpty() ? ResponseEntity.ok(lancamentosEncontrados)
				: ResponseEntity.noContent().build();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> buscarPorId(@PathVariable Long codigo) {
		Lancamento lancamento = this.lancamentoService.buscarPessoaPeloId(codigo);
		return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Lancamento> remover(@PathVariable Long codigo) {
		Lancamento lancamentoDeletado = this.lancamentoService.remover(codigo);
		return lancamentoDeletado != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Lancamento> atualizar(@PathVariable Long codigo, @RequestBody @Valid Lancamento lancamento) {
		Lancamento lancamentoAtualizado = this.lancamentoService.atualizar(codigo, lancamento);
		return lancamentoAtualizado != null ? ResponseEntity.ok(lancamentoAtualizado)
				: ResponseEntity.notFound().build();
	}

}
