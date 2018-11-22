package com.everis.start.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.everis.start.domain.Funcionario;
import com.everis.start.dto.FuncionarioDTO;
import com.everis.start.services.FuncionarioService;

/**
 * Esta Classe Implementa os endpoint (GET, POST, DELETE e PUT). E faz o acesso
 * a CAMADA DE SERVICOS que por sua vez acessam a CAMADA DE
 * DADOS(MongoRepository).
 * 
 * @author Patrick Farias
 * @since 1.0
 * @version 1.0 (Nov. 2018)
 * 
 */

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

	// Injeção de Dependencia
	@Autowired
	private FuncionarioService service;

	/**
	 * @return {@code ResponseEntity<FuncionarioDTO>} [ Retorna um ArrayList de
	 *         FuncionariosDTO ]
	 */

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FuncionarioDTO>> findAll() {

		List<Funcionario> list = service.findAll();

		// Uso de expressoes lambda para converter
		// uma List<Funcionario> em uma List<FuncionarioDTO>
		List<FuncionarioDTO> listDto = list.stream().map(x -> new FuncionarioDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);
	}

	/**
	 * @param id [ representa o @Id(chave primaria) da classe FuncionarioDTO]
	 * @return {@code ResponseEntity<FuncionarioDTO>} [ Retorna um ArrayList de
	 *         Funcionarios DTO ]
	 */

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<FuncionarioDTO> findById(@PathVariable String id) {

		Funcionario fun = service.findById(id);

		return ResponseEntity.ok().body(new FuncionarioDTO(fun));
	}

	/**
	 * @param objDto [ representa um objeto da classe FuncionarioDTO ]
	 * @return {@code  ResponseEntity<Void>} [ Retorna o
	 *         status(HttpStatus.NO_CONTENT) = codigo 201 Created ]
	 */

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody FuncionarioDTO objDto) {
		Funcionario obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getMatricula())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	/**
	 * @param id [ representa o @Id(chave primaria) da classe FuncionarioDTO]
	 * @return {@code  ResponseEntity<Void>} [ Retorna o
	 *         status(HttpStatus.NO_CONTENT) = codigo 204 No Content ]
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	/**
	 * @param objDto [ representa um objeto da classe FuncionarioDTO ]
	 * @param id     [ representa o @Id(chave primaria) da classe FuncionarioDTO]
	 * 
	 * @return {@code  ResponseEntity<Void>} [ Retorna o
	 *         status(HttpStatus.NO_CONTENT) = codigo 204 No Content ]
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody FuncionarioDTO objDto, @PathVariable String id) {
		Funcionario obj = service.fromDTO(objDto);
		obj.setMatricula(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

}
