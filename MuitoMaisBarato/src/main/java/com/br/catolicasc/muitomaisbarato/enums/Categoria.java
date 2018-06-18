package com.br.catolicasc.muitomaisbarato.enums;

public enum Categoria {
	
	BEBIDA("Bebida"),
	BELEZA("Beleza"),
	CARNE("Carne"),
	HIGIENE("Higiene"),
	FRUTA("Fruta"),
	VERDURA("Verdura"),
	LIMPEZA("Limpeza"),
	MASSA("Massa"),
	TEMPERO("Tempero"),
	PADARIA("Padaria"),
	APERITIVO("Aperitivo"),
	DESCONHECIDO("Desconhecido");
	
	private String nome;
	
	private Categoria(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}

}
