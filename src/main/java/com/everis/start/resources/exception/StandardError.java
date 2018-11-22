package com.everis.start.resources.exception;

import java.io.Serializable;

/**
 * Esta Classe Implementa o tramento gerado pela classe
 * ResourceExceptionHandler, fazendo com que quando o usuario passar uma
 * requisicao incorreta, ele retorno o erro 404 Not Found ao inves de um erro
 * 500 Internal Server Erro.
 * 
 * @author Patrick Farias
 * @since 1.0
 * @version 1.0 (Nov. 2018)
 * 
 */

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public StandardError() {
	}

	/**
	 * @param timestamp [ momento em milisegundos em que a excecao foi lancada ]
	 * @param status    [ httpStatus da resposta a requisicao, podendo ser por
	 *                  exemplo: 200,204,404,500 ]
	 * @param error     [ excessao gerada na classe ObjectNotFoundException ]
	 * @param message   [ mensagem que desejamos retornar ao usuario para explicar o
	 *                  motivo da excessao gerada ]
	 * @param path      [ caminho do erro gerado pela requisicao HttpServletRequest
	 *                  ]
	 */

	public StandardError(Long timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
