package com.catolicasc.maisbarato.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.catolicasc.maisbarato.enums.Permissao;

@Entity
public class Cliente extends Usuario {

	@OneToOne
	private ListaCompras listaCompras;

	Cliente() {
		this.setRole(Permissao.USUARIO);
	}

	public ListaCompras getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(ListaCompras listaCompras) {
		this.listaCompras = listaCompras;
	}

}
