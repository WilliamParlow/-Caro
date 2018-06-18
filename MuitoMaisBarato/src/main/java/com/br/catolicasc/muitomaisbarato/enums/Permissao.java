package com.br.catolicasc.muitomaisbarato.enums;

public enum Permissao {
	ESTABELECIMENTO("ESTABELECIMENTO"),
	ADMINISTRADOR("ADMINISTRADOR"),
	USUARIO("USUARIO");
	
	Permissao(String permissao) {
		this.permissao = permissao;
	}
	
	private String permissao;
	
	public String getPermicao() {
		return this.permissao;
	}
	
}
