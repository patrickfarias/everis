package com.everis.start.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.everis.start.domain.Funcionario;
import com.everis.start.domain.Pessoa;

/**
 * Classe utilizada com o objetivo de: Carregar dados das entidades de forma
 * simples, podendo inclusive "projetar" apenas alguns dados da entidade
 * original.
 * 
 * 
 * @author Patrick Farias
 * @since 1.0
 * @version 1.0 (Nov. 2018)
 * 
 */

public class FuncionarioDTO extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	public String nome;

	public LocalDate data_nascimento;
	public String matricula;
	public String funcao;
	public LocalDate data_contratacao;

	// Construtor
	public FuncionarioDTO() {
	}

	/**
	 * @param funcionario [Objeto da Classe Funcionario]
	 */
	public FuncionarioDTO(Funcionario funcionario) {

		matricula = funcionario.getMatricula();
		funcao = funcionario.getFuncao();
		data_contratacao = funcionario.getData_contratacao();

		nome = funcionario.getNome();
		data_nascimento = funcionario.getData_nascimento();

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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public LocalDate getData_contratacao() {
		return data_contratacao;
	}

	public void setData_contratacao(LocalDate data_contratacao) {
		this.data_contratacao = data_contratacao;
	}

}
