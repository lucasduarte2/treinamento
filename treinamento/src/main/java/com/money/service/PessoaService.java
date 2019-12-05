package com.money.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.money.model.Pessoa;
import com.money.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> listar() {
		return this.pessoaRepository.findAll();
	}

	public Pessoa salvar(Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}

	public Pessoa buscarPessoaPeloId(Long codigo) {
		return this.pessoaRepository.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	public Pessoa remover(Long codigo) {
		Pessoa pessoaCadastrada = this.buscarPessoaPeloId(codigo);
		this.pessoaRepository.delete(pessoaCadastrada);
		return pessoaCadastrada;
	}

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = this.buscarPessoaPeloId(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		this.pessoaRepository.save(pessoaSalva);
		return this.pessoaRepository.save(pessoaSalva);
	}

	public Pessoa atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoaSalva = buscarPessoaPeloId(codigo);
		pessoaSalva.setAtivo(ativo);
		return this.pessoaRepository.save(pessoaSalva);
	}

}
