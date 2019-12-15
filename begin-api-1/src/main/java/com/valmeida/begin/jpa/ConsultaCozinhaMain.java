package com.valmeida.begin.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import com.valmeida.begin.BeginApi1Application;
import com.valmeida.begin.domain.model.Cozinha;
import com.valmeida.begin.domain.repository.CozinhaRepository;
import com.valmeida.begin.infrastructure.repository.CozinhaRepositoryImpl;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext app = new SpringApplicationBuilder(BeginApi1Application.class).web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository = app.getBean(CozinhaRepositoryImpl.class);
		
		Cozinha brasileira = new Cozinha();
		brasileira.setNome("Brasileira");
		
		Cozinha japonesa = new Cozinha();
		japonesa.setNome("Japonesa");
		
		brasileira = cozinhaRepository.salvar(brasileira);
		japonesa = cozinhaRepository.salvar(japonesa);
		
		System.out.printf("%d - %s\n", brasileira.getId(), brasileira.getNome());
		System.out.printf("%d - %s\n", japonesa.getId(), japonesa.getNome());
		
		Cozinha cozinha = cozinhaRepository.buscar(1L);
		
		System.out.printf("%d - %s\n", cozinha.getId(), cozinha.getNome());
		
	}

}
