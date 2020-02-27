package com.br.pratica.controleponto.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.br.pratica.controleponto.api.enums.PerfilEnum;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable{

	private static final long serialVersionUID = -4822412941655353592L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name = "nome",nullable = false)
	private String nome;
	
	@Column(name = "email",nullable = false)
	private String email;
	
	@Column(name = "senha",nullable = false)
	private String senha;
	
	@Column(name = "cpf",nullable = false)
	private String cpf;
	
	@Column(name = "valor_hora",nullable = true)
	private BigDecimal valorhora;
	
	@Column(name = "qtd_horas_trabalho_dia",nullable = true)
	private Float qtdHorasTrabalhadoDia;
	
	@Column(name = "qtd_horas_almoco",nullable = true)
	private Float qtdHorasAlmoco;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil",nullable = false)
	private PerfilEnum perfil;
	
	@Column(name = "data_criacao", nullable = false)
	private LocalDate dataCriacao;
	
	@Column(name = "data_atualizacao", nullable = false)
	private LocalDate dataAtualizacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa empresa;
	
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Lancamento> lancamentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getValorhora() {
		return valorhora;
	}

	public void setValorhora(BigDecimal valorhora) {
		this.valorhora = valorhora;
	}

	public Float getQtdHorasTrabalhadoDia() {
		return qtdHorasTrabalhadoDia;
	}

	public void setQtdHorasTrabalhadoDia(Float qtdHorasTrabalhadoDia) {
		this.qtdHorasTrabalhadoDia = qtdHorasTrabalhadoDia;
	}

	public Float getQtdHorasAlmoco() {
		return qtdHorasAlmoco;
	}

	public void setQtdHorasAlmoco(Float qtdHorasAlmoco) {
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao =  LocalDate.now();
	}
	
	@PrePersist
	public void prePersist() {
		LocalDate data_atual = LocalDate.now();
		dataCriacao = data_atual;
		dataAtualizacao = data_atual;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", valorhora=" + valorhora + ", qtdHorasTrabalhadoDia=" + qtdHorasTrabalhadoDia + ", qtdHorasAlmoco="
				+ qtdHorasAlmoco + ", perfil=" + perfil + ", dataCriacao=" + dataCriacao + ", dataAtualizacao="
				+ dataAtualizacao + ", empresa=" + empresa.getRazaoSocial() + "]";
	}
	
	
	
}
