package com.br.catolicasc.muitomaisbarato.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.catolicasc.muitomaisbarato.enums.Categoria;
import com.br.catolicasc.muitomaisbarato.enums.Permissao;
import com.br.catolicasc.muitomaisbarato.models.Cliente;
import com.br.catolicasc.muitomaisbarato.models.Estabelecimento;
import com.br.catolicasc.muitomaisbarato.models.Usuario;
import com.br.catolicasc.muitomaisbarato.repository.ClienteRepository;
import com.br.catolicasc.muitomaisbarato.repository.EstabelecimentoRepository;
import com.br.catolicasc.muitomaisbarato.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	EstabelecimentoRepository estabRepo;
	
	@Autowired
	ClienteRepository clRepo;
	
	@GetMapping("/")
	public ModelAndView login() {
		
		ModelAndView mv = new ModelAndView("login");
		List<Permissao> permissoes = new ArrayList<>();
		
		permissoes.add(Permissao.ESTABELECIMENTO);
		permissoes.add(Permissao.USUARIO);
		
		mv.addObject("usuario", new Usuario());
		mv.addObject("roles", permissoes);
		
		return mv;
		
	}

	@PostMapping("/loginAction")
	public ModelAndView loginAction() {

		return new ModelAndView("Estabelecimento/estabelecimento");

	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(@ModelAttribute Usuario usuario) {
		
		return new ModelAndView("Estabelecimento/estabelecimento");

	}

}
