package com.catolicasc.maisbarato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListaComprasController {

	@RequestMapping(value="/cadastrar-lista-de-compras")
	public String cadastrarListaCompras() {
		return "cadastrar-estabelecimento";
	}
	
	@RequestMapping(value="lista-de-compras")
	public String listaDeListaCompras() {
		return "lista-de-estabelecimentos";
	}
	
	@RequestMapping(value="editar-lista-de-compras")
	public String editarListaCompras() {
		return "editar-estabelecimentos";
	}
	
	@RequestMapping(value="deletar-lista-de-compras")
	public String deletarListaCompras() {
		return "deletar-estabelecimento";
	}
	
}
