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


import com.br.catolicasc.muitomaisbarato.models.Cliente;
import com.br.catolicasc.muitomaisbarato.service.ClienteService;

@Controller
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
    private ClienteService service;
		
	 @GetMapping("/")
	    public ModelAndView findAll() {	         
	        ModelAndView mv = new ModelAndView("Cliente/cliente");
	        mv.addObject("clientes", service.findAll());
	        return mv;
	    }
	 @GetMapping("/add")
	    public ModelAndView add(Cliente cliente) {
	         
	        ModelAndView mv = new ModelAndView("Cliente/clienteAdd");
	        mv.addObject("cliente", cliente);
	         
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
	    public ModelAndView save(@Valid Cliente cliente, BindingResult result) {
	         
	        if(result.hasErrors()) {
	            return add(cliente);
	        }
	         
	        service.save(cliente);
	         
	        return findAll();
	    }
	 }
