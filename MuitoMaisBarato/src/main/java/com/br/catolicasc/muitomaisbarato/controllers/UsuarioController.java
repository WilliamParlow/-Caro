package com.br.catolicasc.muitomaisbarato.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.catolicasc.muitomaisbarato.enums.Permissao;
import com.br.catolicasc.muitomaisbarato.models.Cliente;
import com.br.catolicasc.muitomaisbarato.models.Estabelecimento;
import com.br.catolicasc.muitomaisbarato.models.Usuario;
import com.br.catolicasc.muitomaisbarato.repository.UsuarioRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repo;

	// CLIENTEEEEEEEEEEEEEEE

	@GetMapping("/cliente")
	public ModelAndView findAllClientes() {
		ModelAndView mv = new ModelAndView("usuario/cliente");

		List<Usuario> clientes = new ArrayList<>();

		for (Usuario user : repo.findAll()) {
			if (user.getRole() == Permissao.USUARIO) {
				clientes.add(user);
			}
		}

		mv.addObject("clientes", clientes);
		return mv;
	}

	@GetMapping("/add-cliente")
	public ModelAndView addUser(Usuario cliente) {

		ModelAndView mv = new ModelAndView("usuario/clienteAdd");
		mv.addObject("cliente", cliente);
		mv.addObject("role", Permissao.USUARIO);

		return mv;
	}

	@GetMapping("/edit-cliente/{id}")
	public ModelAndView editUser(@PathVariable("id") Long id) {

		return addUser(repo.findById(id).get());
	}

	@GetMapping("/delete-cliente/{id}")
	public ModelAndView deleteUser(@PathVariable("id") Long id) {

		repo.delete(repo.findById(id).get());

		return findAllClientes();
	}

	@PostMapping("/save-cliente")
	public ModelAndView saveUser(@Valid Usuario cliente, BindingResult result) {

		if (result.hasErrors()) {
			return addUser(cliente);
		}

		cliente.setCliente(new Cliente());
		cliente.setRole(Permissao.USUARIO);
		repo.save(cliente);

		return findAllClientes();
	}

	// ESTABELECIMENTOOOOOOOOOOOOOOOOO

	@GetMapping("/estabelecimento")
	public ModelAndView findAllEstabelecimentos() {
		ModelAndView mv = new ModelAndView("usuario/estabelecimento");

		List<Usuario> estabelecimentos = new ArrayList<>();

		for (Usuario user : repo.findAll()) {
			if (user.getRole() == Permissao.ESTABELECIMENTO) {
				estabelecimentos.add(user);
			}
		}

		mv.addObject("estabelecimentos", estabelecimentos);
		return mv;
	}

	@GetMapping("/add-estabelecimento")
	public ModelAndView addEstabelecimento(Usuario estabelecimento) {

		ModelAndView mv = new ModelAndView("usuario/estabelecimentoAdd");
		mv.addObject("estabelecimento", estabelecimento);
		mv.addObject("role", Permissao.ESTABELECIMENTO);

		return mv;
	}

	@GetMapping("/edit-estabelecimento/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		return addEstabelecimento(repo.findById(id).get());
	}

	@GetMapping("/delete-estabelecimento/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		repo.delete(repo.findById(id).get());

		return findAllEstabelecimentos();
	}

	@PostMapping("/save-estabelecimento")
	public ModelAndView save(@Valid Usuario estabelecimento, BindingResult result) {

		if (result.hasErrors()) {
			return addEstabelecimento(estabelecimento);
		}

		estabelecimento.setEstabelecimento(new Estabelecimento());
		estabelecimento.setRole(Permissao.ESTABELECIMENTO);
		repo.save(estabelecimento);

		return findAllEstabelecimentos();
	}

}
