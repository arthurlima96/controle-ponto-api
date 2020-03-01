package com.br.pratica.controleponto.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.br.pratica.controleponto.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);
}
