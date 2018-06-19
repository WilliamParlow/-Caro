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
import com.br.catolicasc.muitomaisbarato.models.Produto;
import com.br.catolicasc.muitomaisbarato.repository.EstabelecimentoRepository;
import com.br.catolicasc.muitomaisbarato.repository.ListaDeComprasRepository;
import com.br.catolicasc.muitomaisbarato.repository.ProdutoRepository;
import com.br.catolicasc.muitomaisbarato.service.ClienteService;
import com.br.catolicasc.muitomaisbarato.service.ListaDeComprasService;

@Controller
@RequestMapping("lista-de-compra")
public class ListaDeCompraController {

	@Autowired
	private ListaDeComprasRepository repo;
	@Autowired
	private ProdutoRepository produtoRepo;

	@GetMapping("/")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("ListaDeCompras/lista-de-compra");
		mv.addObject("listasdecompras", repo.findAll());
		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(ListaCompras listaCompras) {

		ModelAndView mv = new ModelAndView("ListaDeCompras/listaDeComprasAdd");
		mv.addObject("listaCompra", listaCompras);
		mv.addObject("produtos", produtoRepo.findAll());

		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		return add(repo.findById(id).get());
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		repo.delete(repo.findById(id).get());

		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid ListaCompras listaCompras, BindingResult result) {

		if (result.hasErrors()) {
			return add(listaCompras);
		}

		repo.save(listaCompras);

		return findAll();
	}
}
