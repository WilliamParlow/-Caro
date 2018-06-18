package com.br.catolicasc.muitomaisbarato.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.catolicasc.muitomaisbarato.models.Produto;
import com.br.catolicasc.muitomaisbarato.service.ProdutoService;




@Controller
@RequestMapping("produto")
public class ProdutoController {
	
	@Autowired
    private ProdutoService service;
		
	 @GetMapping("/")
	    public ModelAndView findAll() {	         
	        ModelAndView mv = new ModelAndView("Produto/produto");
	        mv.addObject("produtos", service.findAll());
	        return mv;
	    }
	 
	 @GetMapping("/add")
	    public ModelAndView add(Produto produto) {
	         
	        ModelAndView mv = new ModelAndView("Produto/produtoAdd");
	        mv.addObject("produto", produto);
	         
	        return mv;
	    }
	   @GetMapping("/edit/{id}")
	    public ModelAndView edit(@PathVariable("id") Long id) {
	         
	        return add(service.findOne(id));
	    }
	     
	    @GetMapping("/delete/{id}")
	    public ModelAndView delete(@PathVariable("id") Long id) {
	         
	        service.delete(id);
	         
	        return findAll();
	    }
	    
	 @PostMapping("/save")
	    public ModelAndView save(@Valid Produto produto, BindingResult result) {
	         
	        if(result.hasErrors()) {
	            return add(produto);
	        }
	         
	        service.save(produto);
	         
	        return findAll();
	    }
	 
	 }
