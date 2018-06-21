package com.br.catolicasc.muitomaisbarato.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.catolicasc.muitomaisbarato.enums.Permissao;
import com.br.catolicasc.muitomaisbarato.models.Cliente;
import com.br.catolicasc.muitomaisbarato.models.Estabelecimento;
import com.br.catolicasc.muitomaisbarato.models.Usuario;
import com.br.catolicasc.muitomaisbarato.repository.UsuarioRepository;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	UsuarioRepository repo;
	
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
	public ModelAndView loginAction(@RequestParam String email, @RequestParam String password) {
		
		List<Usuario> usuarios = new ArrayList<>();
		
		System.out.println(email);
		System.out.println(password);
		System.out.println("---");
		
		for (Usuario user : repo.findAll()) {
			System.out.println(user.getEmail().equals(email) && user.getPassword().equals(password));
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				usuarios.add(user);
			}
		}
		
		if (usuarios.isEmpty()) {
			return login();
		}

		return new ModelAndView("index");

	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(@Valid @ModelAttribute Usuario usuario, BindingResult result) {
		
		if (result.hasErrors()) {
			return new ModelAndView("login/login");
		}
		
		if (usuario.getRole() == Permissao.ESTABELECIMENTO) {
			usuario.setEstabelecimento(new Estabelecimento());
		} else {
			usuario.setCliente(new Cliente());
		}
		
		repo.save(usuario);
		
		return new ModelAndView("index");

	}

}
