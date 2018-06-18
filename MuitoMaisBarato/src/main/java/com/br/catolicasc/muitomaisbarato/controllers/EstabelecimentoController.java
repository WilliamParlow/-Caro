package com.br.catolicasc.muitomaisbarato.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("cliente")
public class EstabelecimentoController {
	
		
	 @GetMapping("/")
	    public ModelAndView findAll() {	         
	        ModelAndView mv = new ModelAndView("Cliente/cliente");
	        return mv;
	    }
	 }
