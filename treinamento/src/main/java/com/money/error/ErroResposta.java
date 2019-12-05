package com.money.error;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ErroResposta {

	private HttpStatus status;
	private Integer codigo;
	private String mensagem;
	private List<String> erros;

	public ErroResposta(HttpStatus status, Integer codigo, String mensagem, List<String> erros) {
		super();
		this.status = status;
		this.codigo = codigo;
		this.mensagem = mensagem;
		this.erros = erros;
	}

	public ErroResposta(HttpStatus status, Integer codigo, String mensagem, String erro) {
		super();
		this.status = status;
		this.codigo = codigo;
		this.mensagem = mensagem;
		this.erros = Arrays.asList(erro);
	}

	public HttpStatus getStatus() {
		return this.status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<String> getErros() {
		return this.erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

}