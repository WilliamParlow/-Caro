package com.br.catolicasc.muitomaisbarato.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.catolicasc.muitomaisbarato.enums.Categoria;
import com.br.catolicasc.muitomaisbarato.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	UsuarioRepository repo;

	@PostMapping("/login")
	public ModelAndView login() {

		return new ModelAndView("Estabelecimento/estabelecimento");

	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(@ModelAttribute Object object) {

		return new ModelAndView("Estabelecimento/estabelecimento");

	}

}
