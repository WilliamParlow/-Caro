package com.br.catolicasc.muitomaisbarato.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.br.catolicasc.muitomaisbarato.enums.Permissao;

@MappedSuperclass
public abstract class Usuario {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private String password;
	private String email;
	private Permissao role;

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

}
