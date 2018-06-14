package com.catolicasc.maisbarato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstabelecimentoController {

	@RequestMapping(value="/cadastrar-estabelecimento")
	public String cadastrarEstabelecimento() {
		return "cadastrar-estabelecimento";
	}
	
	@RequestMapping(value="lista-de-estabelecimentos")
	public String listaDeEstabelecimentos() {
		return "lista-de-estabelecimentos";
	}
	
	@RequestMapping(value="editar-estabelecimento")
	public String editarEstabelecimento() {
		return "editar-estabelecimentos";
	}
	
	@RequestMapping(value="deletar-estabelecimento")
	public String deletarEstabelecimento() {
		return "deletar-estabelecimento";
	}
	
}
