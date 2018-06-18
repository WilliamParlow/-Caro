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
import com.br.catolicasc.muitomaisbarato.models.ListaCompras;
import com.br.catolicasc.muitomaisbarato.repository.EstabelecimentoRepository;
import com.br.catolicasc.muitomaisbarato.repository.ListaDeComprasRepository;
import com.br.catolicasc.muitomaisbarato.service.ClienteService;
import com.br.catolicasc.muitomaisbarato.service.ListaDeComprasService;

@Controller
@RequestMapping("lista-de-compra")
public class ListaDeCompraController {
	
	@Autowired
	private ListaDeComprasService service;
	 @GetMapping("/")
	    public ModelAndView findAll() {	         
	        ModelAndView mv = new ModelAndView("ListaDeCompras/lista-de-compra");
	        return mv;
	    }
	 
	 @GetMapping("/add")
		public ModelAndView add(ListaCompras listaCompras) {

			ModelAndView mv = new ModelAndView("ListaDeCompras/lisdaDeComprasAdd");
			mv.addObject("listaCompras", listaCompras);

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
		public ModelAndView save(@Valid ListaCompras listaCompras, BindingResult result) {

			if (result.hasErrors()) {
				return add(listaCompras);
			}

			service.save(listaCompras);

			return findAll();
		}
	 }
