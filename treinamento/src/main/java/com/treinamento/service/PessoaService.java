package com.treinamento.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.treinamento.model.Pessoa;
import com.treinamento.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> listar() {
		return this.pessoaRepository.findAll();
	}

	public Pessoa buscarPessoaPeloId(Long codigo) {
		return this.pessoaRepository.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	public Pessoa cadastrarPessoa(Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}

	public Pessoa deletarPessoa(Long id) {
		Pessoa PessoaSalva = buscarPessoaPeloId(id);
		this.pessoaRepository.delete(PessoaSalva);
		return PessoaSalva;
	}

	public Pessoa atualizarPessoa(Long id, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPeloId(id);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
		pessoaRepository.save(pessoaSalva);
		return pessoaSalva;
	}
	
	public Pessoa atualizarPropriedadeAtivo(Long id, Boolean ativo) {
		Pessoa pessoaSalva = buscarPessoaPeloId(id);
		pessoaSalva.setAtivo(ativo);
		return pessoaRepository.save(pessoaSalva);
	}

}
