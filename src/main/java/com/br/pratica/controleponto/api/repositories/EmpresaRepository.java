package com.br.pratica.controleponto.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pratica.controleponto.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	Empresa findByCnpj(String cnpj);
}
