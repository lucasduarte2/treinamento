package com.treinamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.model.Categoria;
import com.treinamento.model.Pessoa;
import com.treinamento.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> listar() {
		return this.pessoaRepository.findAll();
	}

	public Pessoa buscarPorId(Long id) {
		Optional<Pessoa> pessoaNoBanco = this.pessoaRepository.findById(id);
		if (pessoaNoBanco.isPresent()) {
			return pessoaNoBanco.get();
		}
		return null;
	}

	public Pessoa cadastrarPessoa(Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}

	public Pessoa deletarPessoa(Long id) {
		Optional<Pessoa> pessoaNoBanco = this.pessoaRepository.findById(id);
		if (pessoaNoBanco.isPresent()) {
			this.pessoaRepository.delete(pessoaNoBanco.get());
			return pessoaNoBanco.get();
		}
		return null;
	}

	public Pessoa atualizarPessoa(Long id, Pessoa pessoa) {
		Optional<Pessoa> pessoaNoBanco = this.pessoaRepository.findById(id);
		if (pessoaNoBanco.isPresent()) {
			pessoa.setCodigo(pessoaNoBanco.get().getCodigo());
			return this.pessoaRepository.save(pessoa);
		}

		return null;
	}

}
