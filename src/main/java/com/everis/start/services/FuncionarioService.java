package com.everis.start.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.start.domain.Funcionario;
import com.everis.start.dto.FuncionarioDTO;
import com.everis.start.repository.FuncionarioRepository;
import com.everis.start.services.exception.ObjectNotFoundException;

/**
 * Esta Classe esta na CAMADA DE SERVICOS e eh acessada pelas classes
 * controladores(Resources) e por sua vez acessam a CAMADA DE
 * DADOS(MongoRepository).
 * 
 * Classe responsavel pela chamada a camada de dados para realizar o CRUD.
 * Metodos implementados: findAll, findById, insert, update, delete e
 * fromDTO(conversao de objeto em um DTO).
 * 
 * @author Patrick Farias
 * @since 1.0
 * @version 1.0 (Nov. 2018)
 * 
 */

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;

	public List<Funcionario> findAll() {
		return repo.findAll();
	}

	public Funcionario findById(String id) {

		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Funcionario insert(Funcionario obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public Funcionario update(Funcionario obj) {
		Funcionario newObj = findById(obj.getMatricula());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Funcionario newObj, Funcionario obj) {

		// Atualização do Objeto: A Matricula(ID), nao pode mudar.
		// Pois ela eh a chave primari.
		// Atualizar somente os outros dados.
		newObj.setNome(obj.getNome());
		newObj.setData_nascimento(obj.getData_nascimento());

		newObj.setFuncao(obj.getFuncao());
		newObj.setData_contratacao(obj.getData_contratacao());

	}

	public Funcionario fromDTO(FuncionarioDTO objDto) {

		Funcionario f = new Funcionario(objDto.getFuncao(), objDto.getMatricula(), objDto.getData_contratacao());
		f.setNome(objDto.getNome());
		f.setData_nascimento(objDto.getData_nascimento());

		return f;
	}

}
