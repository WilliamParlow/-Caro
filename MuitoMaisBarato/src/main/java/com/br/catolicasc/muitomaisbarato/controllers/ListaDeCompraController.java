package com.br.catolicasc.muitomaisbarato.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("lista-de-compra")
public class ListaDeCompraController {
	
		
	 @GetMapping("/")
	    public ModelAndView findAll() {	         
	        ModelAndView mv = new ModelAndView("ListaDeCompras/lista-de-compra");
	        return mv;
	    }
	 }
