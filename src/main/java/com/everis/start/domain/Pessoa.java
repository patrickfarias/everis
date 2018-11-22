package com.everis.start.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe responsavel pela criacao do Objeto Pessoa
 * 
 * @author Patrick Farias
 * @since 1.0
 * @version 1.0 (Nov. 2018)
 * 
 */

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	public String nome;
	public LocalDate data_nascimento;

	public Pessoa() {
		super();
	}

	/**
	 * @param nome            [nome da pessoa]
	 * @param data_nascimento [data de nascimento da pessoa]
	 */

	public Pessoa(String nome, LocalDate data_nascimento) {
		super();
		this.nome = nome;
		this.data_nascimento = data_nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", data_nascimento=" + data_nascimento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_nascimento == null) ? 0 : data_nascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (data_nascimento == null) {
			if (other.data_nascimento != null)
				return false;
		} else if (!data_nascimento.equals(other.data_nascimento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
