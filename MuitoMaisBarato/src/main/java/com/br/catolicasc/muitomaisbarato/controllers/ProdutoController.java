package com.br.catolicasc.muitomaisbarato.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("produto")
public class ProdutoController {
	
		
	 @GetMapping("/")
	    public ModelAndView findAll() {	         
	        ModelAndView mv = new ModelAndView("Produto/produto");
	        return mv;
	    }
	 }
