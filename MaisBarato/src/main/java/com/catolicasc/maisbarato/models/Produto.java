package com.catolicasc.maisbarato.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.catolicasc.maisbarato.enums.Categoria;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String descricao;
	private Categoria categoria;
	private String marca;

}
