package com.br.pratica.controleponto.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "empresa")
public class Empresa implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String razaoSocial;
	private String cnpj;
	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;
	
	
}
