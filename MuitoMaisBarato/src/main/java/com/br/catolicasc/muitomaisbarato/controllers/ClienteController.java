package com.br.catolicasc.muitomaisbarato.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.catolicasc.muitomaisbarato.models.Cliente;

@Controller
@RequestMapping("cliente")
public class ClienteController {

	@GetMapping("/")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("Cliente/cliente");
		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Cliente cliente) {

		ModelAndView mv = new ModelAndView("Cliente/clienteAdd");
		mv.addObject("cliente", cliente);

		return mv;
	}
}
