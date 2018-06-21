package com.br.catolicasc.muitomaisbarato.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

import com.br.catolicasc.muitomaisbarato.enums.Permissao;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private String password;

	@Column(unique = true)
	private String email;
	
	private Permissao role;

	@OneToOne(cascade = CascadeType.ALL)
	private Estabelecimento estabelecimento;
	@OneToOne(cascade = CascadeType.ALL)
	private Cliente cliente;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Permissao getRole() {
		return role;
	}

	public void setRole(Permissao role) {
		this.role = role;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
