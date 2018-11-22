package com.everis.start.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.everis.start.domain.Funcionario;
import com.everis.start.repository.FuncionarioRepository;

/**
 * Classe utilizada para Polular manualmente a Base de Dados.
 * 
 * 
 * @author Patrick Farias
 * @since 1.0
 * @version 1.0 (Nov. 2018)
 * 
 */

@Configuration
public class Instantiation implements CommandLineRunner {

	// Camada de acesso a dados(Repository)
	@Autowired
	private FuncionarioRepository funcionarioReposiroty;

	@Override
	public void run(String... arg0) throws Exception {

		// Deleta todos os registros do banco
		funcionarioReposiroty.deleteAll();

		// Popula novamente o banco.
		Funcionario f1 = new Funcionario("Analista", "1341", LocalDate.of(2018, Month.JULY, 2));
		f1.setNome("Olivia Palito");
		f1.setData_nascimento(LocalDate.of(1995, Month.NOVEMBER, 8));

		Funcionario f2 = new Funcionario("Programador", "8", LocalDate.now().minusYears(5));
		f2.setNome("Patrick Farias");
		f2.setData_nascimento(LocalDate.now().minusYears(25));

		Funcionario f3 = new Funcionario("Gerente de Projeto", "55", LocalDate.now().minusYears(10));
		f3.setNome("Reinaldo Lemos");
		f3.setData_nascimento(LocalDate.now().minusYears(30));

		// Salvar dados no banco
		funcionarioReposiroty.saveAll(Arrays.asList(f1, f2, f3));
	}

}
