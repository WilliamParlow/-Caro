package com.catolicasc.maisbarato.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.catolicasc.maisbarato.enums.Permissao;

@Entity
public class Estabelecimento extends Usuario {

	@OneToMany
	private List<Preco> precos;
	
	private String endereco;
	
	private String cnpj;
	
	private String nome;

	public Estabelecimento() {
		this.setRole(Permissao.ESTABELECIMENTO);
	}

	public List<Preco> getPrecos() {
		return precos;
	}

	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
