package com.br.pratica.controleponto.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.br.pratica.controleponto.api.entities.Empresa;
import com.br.pratica.controleponto.api.repositories.EmpresaRepository;


@SpringBootApplication
public class ControlePontoApplication {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ControlePontoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(){
//		return args-> {
//			Empresa empresa = new Empresa();
//			empresa.setRazaoSocial("Arthur LTDA");
//			empresa.setCnpj("38839109000190");
//			
//			this.empresaRepository.save(empresa);
//			
//			List<Empresa> empresas = empresaRepository.findAll();
//			empresas.forEach(System.out::println);
//		};
//	}
}
