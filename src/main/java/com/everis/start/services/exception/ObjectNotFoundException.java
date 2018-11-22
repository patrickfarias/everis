package com.everis.start.services.exception;

/**
 * Esta Classe faz o tratamento das excessoes para o caso de uma requisição
 * gerar em exception. extende da RuntimeException que é uma excessao padrao
 * java que o compilador nao exige que seja tratada.
 * 
 * @author Patrick Farias
 * @since 1.0
 * @version 1.0 (Nov. 2018)
 * 
 */

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
