package com.catolicasc.maisbarato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

	@RequestMapping(value="/cadastrar-usuario")
	public String cadastrarUsuario() {
		return "cadastrar-usuario";
	}
	
	@RequestMapping(value="lista-de-usuarios")
	public String listaDeUsuarios() {
		return "lista-de-usuarios";
	}
	
	@RequestMapping(value="editar-usuario")
	public String editarUsuario() {
		return "editar-usuario";
	}
	
	@RequestMapping(value="deletar-usuario")
	public String deletarUsuario() {
		return "deletar-usuario";
	}
	
}
