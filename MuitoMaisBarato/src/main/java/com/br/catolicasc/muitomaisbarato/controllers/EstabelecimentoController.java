package com.br.catolicasc.muitomaisbarato.controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.catolicasc.muitomaisbarato.models.Estabelecimento;
import com.br.catolicasc.muitomaisbarato.repository.EstabelecimentoRepository;

@Controller
@RequestMapping("estabelecimento")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoRepository repo;

	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("Estabelecimento/estabelecimento");
		mv.addObject("estabelecimentos", repo.findAll());
		
		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Estabelecimento estabelecimento) {

		ModelAndView mv = new ModelAndView("Estabelecimento/estabelecimentoAdd");
		mv.addObject("estabelecimento", estabelecimento);

		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Estabelecimento estabelecimento = repo.findById(id).get();

		ModelAndView mv = new ModelAndView("Estabelecimento/estabelecimentoAdd");
		mv.addObject("estabelecimento", estabelecimento);

		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@ModelAttribute Estabelecimento estabelecimento) {
		
		repo.save(estabelecimento);
		
		ModelAndView mv = new ModelAndView("Estabelecimento/estabelecimento");
		mv.addObject("estabelecimentos", repo.findAll());
		
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		repo.delete(repo.findById(id).get());
		
		ModelAndView mv = new ModelAndView("Estabelecimento/estabelecimento");
		mv.addObject("estabelecimentos", repo.findAll());
		
		return mv;
		
	}

}
