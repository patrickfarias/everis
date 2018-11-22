package com.everis.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.everis.start.domain.Funcionario;

/**
 * Interface utilizada com o objetivo de: Ser repositorio de funcionarios que
 * extende do MongoRepository, classe responsavel por todo o acesso a camada de
 * Dados.
 * 
 * Os parametros recebidos MongoRepository(classe extendida) sao um objeto do
 * tipo Funcionario e uma String que representa o @Id(chave primaria) da classe
 * Funcionario.
 * 
 * 
 * @author Patrick Farias
 * @since 1.0
 * @version 1.0 (Nov. 2018)
 */

@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

}
