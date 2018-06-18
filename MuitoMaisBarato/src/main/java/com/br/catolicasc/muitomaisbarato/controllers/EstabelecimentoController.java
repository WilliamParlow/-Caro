package com.br.catolicasc.muitomaisbarato.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("estabelecimento")
public class EstabelecimentoController {
	
		
	 @GetMapping("/")
	    public ModelAndView findAll() {	         
	        ModelAndView mv = new ModelAndView("Estabelecimento/estabelecimento");
	        return mv;
	    }
	 }
