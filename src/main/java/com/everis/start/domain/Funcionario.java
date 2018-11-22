package com.everis.start.domain;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe responsavel pela criacao do Objeto Funcionario
 * 
 * @author Patrick Farias
 * @since 1.0
 * @version 1.0 (Nov. 2018)
 * 
 */

@Document(collection = "funcionario")
public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	public String matricula;
	public String funcao;
	public LocalDate data_contratacao;

	// Construtor
	public Funcionario() {
		super();

	}

	/**
	 * 
	 * construtor da Super Classe Pessoa
	 * 
	 * @param nome            [nome do Funcionario]
	 * @param data_nascimento [data de nascimento do Funcionario]
	 */
	public Funcionario(String nome, LocalDate data_nascimento) {
		super(nome, data_nascimento);

	}

	/**
	 * @param funcao           [funcao do Funcionario]
	 * @param matricula        [matricula do funcionario no Dep. Rec. Humanos]
	 * @param data_contratacao [data do inicio das atividades como PJ ou CLT]
	 */
	public Funcionario(String funcao, String matricula, LocalDate data_contratacao) {
		super();

		this.funcao = funcao;
		this.matricula = matricula;
		this.data_contratacao = data_contratacao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public LocalDate getData_contratacao() {
		return data_contratacao;
	}

	public void setData_contratacao(LocalDate data_contratacao) {
		this.data_contratacao = data_contratacao;
	}

	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", funcao=" + funcao + ", data_contratacao=" + data_contratacao
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((data_contratacao == null) ? 0 : data_contratacao.hashCode());
		result = prime * result + ((funcao == null) ? 0 : funcao.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (data_contratacao == null) {
			if (other.data_contratacao != null)
				return false;
		} else if (!data_contratacao.equals(other.data_contratacao))
			return false;
		if (funcao == null) {
			if (other.funcao != null)
				return false;
		} else if (!funcao.equals(other.funcao))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
