package com.br.catolicasc.muitomaisbarato.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.catolicasc.muitomaisbarato.repository.ClienteRepository;
import com.br.catolicasc.muitomaisbarato.repository.EstabelecimentoRepository;
import com.br.catolicasc.muitomaisbarato.service.ClienteService;
import com.br.catolicasc.muitomaisbarato.service.ProdutoService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	ClienteRepository repoCliente;
	@Autowired
	EstabelecimentoRepository repoEstabelecimento;
	@Autowired
	ProdutoService pservice;
		
	 @GetMapping("/")
	    public ModelAndView findAll() {	         
	        ModelAndView mv = new ModelAndView("index");
	        mv.addObject("qtdClientes", repoCliente.count());
	        mv.addObject("qtdEstabelecimentos", repoEstabelecimento.count());
	        mv.addObject("qtdProdutos", pservice.contProduto());
	        return mv;
	    }

}
