package com.money.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.money.model.Lancamento;
import com.money.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	public List<Lancamento> listar() {
		return this.lancamentoRepository.findAll();
	}

	public Lancamento salvar(Lancamento lancamento) {
		return this.lancamentoRepository.save(lancamento);
	}

	public Lancamento buscarPessoaPeloId(Long codigo) {
		return this.lancamentoRepository.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	public Lancamento remover(Long codigo) {
		Lancamento lancamentoCadastrado = this.buscarPessoaPeloId(codigo);
		this.lancamentoRepository.delete(lancamentoCadastrado);
		return lancamentoCadastrado;
	}

	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		Lancamento lancamentoSalvo = this.buscarPessoaPeloId(codigo);
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
		this.lancamentoRepository.save(lancamentoSalvo);
		return this.lancamentoRepository.save(lancamentoSalvo);
	}

}
