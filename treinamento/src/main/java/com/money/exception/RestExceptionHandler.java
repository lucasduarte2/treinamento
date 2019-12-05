package com.money.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.money.error.ErroResposta;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	// Excecao lancada quando o argumento anotado com a validacao com @Valid falha

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String mensagem = "A requisicao possui campos invalidos";

		List<String> erros = getErrors(exception);
		ErroResposta apiError = new ErroResposta(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
				mensagem, erros);

		return handleExceptionInternal(exception, apiError, headers, apiError.getStatus(), request);
	}

	private List<String> getErrors(MethodArgumentNotValidException exception) {
		List<String> erros = new ArrayList<>();

		for (FieldError erroNoCampo : exception.getBindingResult().getFieldErrors()) {
			erros.add(erroNoCampo.getField() + ": " + erroNoCampo.getDefaultMessage());
		}

		for (ObjectError objectErro : exception.getBindingResult().getGlobalErrors()) {
			erros.add(objectErro.getObjectName() + ": " + objectErro.getDefaultMessage());
		}

		return erros;
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException exception,
			WebRequest request) {

		String mensagem = "O recurso nao foi encontrado";

		ErroResposta erro = new ErroResposta(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.value(),
				mensagem, exception.getLocalizedMessage());

		return handleExceptionInternal(exception, erro, new HttpHeaders(), erro.getStatus(), request);
	}

	@ExceptionHandler(CategoriaNaoEncontradaException.class)
	public ResponseEntity<Object> handleCategoriaNaoEncontradaExcetion(Exception exception, WebRequest request) {

		String mensagem = "A categoria nao foi encontrada";

		ErroResposta apiError = new ErroResposta(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), mensagem,
				exception.getLocalizedMessage());

		return handleExceptionInternal(exception, apiError, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	// Lancada para as demais excecoes nao manipualdas

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception exception, WebRequest request) {

		String mensagem = "Ocorreu um erro interno";
		ErroResposta apiError = new ErroResposta(HttpStatus.INTERNAL_SERVER_ERROR,
				HttpStatus.INTERNAL_SERVER_ERROR.value(), mensagem, exception.getLocalizedMessage());

		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

}
