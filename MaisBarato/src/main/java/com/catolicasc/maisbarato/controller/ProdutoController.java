package com.catolicasc.maisbarato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutoController {

	@RequestMapping(value="/cadastrar-produto")
	public String cadastrarProduto() {
		return "cadastrar-produto";
	}
	
	@RequestMapping(value="lista-de-produtos")
	public String listaDeProdutos() {
		return "lista-de-produtos";
	}
	
	@RequestMapping(value="editar-produto")
	public String editarProduto() {
		return "editar-produto";
	}
	
	@RequestMapping(value="deletar-produto")
	public String deletarProduto() {
		return "deletar-produto";
	}
	
}
