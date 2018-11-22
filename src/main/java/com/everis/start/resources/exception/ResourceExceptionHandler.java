package com.everis.start.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.everis.start.services.exception.ObjectNotFoundException;

/**
 * Classe de tratamento de excessoes para requisicoes nao encontradas.
 * 
 * @author Patrick Farias
 * @since 1.0
 * @version 1.0 (Nov. 2018)
 * 
 */

@ControllerAdvice
public class ResourceExceptionHandler {

	/**
	 * @param e       [ mensagem gerada pela exception da classe
	 *                ObjectNotFoundException ]
	 * @param request [ caminho do path ]
	 * @return {@code  ResponseEntity<StandardError>} [ Retorna o new
	 *         DefaultBuilder(status) = codigo 404 Not Found ]
	 */

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado",
				e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
