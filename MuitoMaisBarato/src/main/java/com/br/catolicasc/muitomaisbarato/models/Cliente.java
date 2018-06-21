package com.br.catolicasc.muitomaisbarato.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

	@Id
	@GeneratedValue
	private long id;

	@OneToOne
	private ListaCompras listaCompras;

	@OneToOne(optional = true)
	private Usuario usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ListaCompras getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(ListaCompras listaCompras) {
		this.listaCompras = listaCompras;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
