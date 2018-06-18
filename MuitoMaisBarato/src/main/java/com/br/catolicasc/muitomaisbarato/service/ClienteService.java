package com.br.catolicasc.muitomaisbarato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.catolicasc.muitomaisbarato.models.Cliente;
import com.br.catolicasc.muitomaisbarato.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
    private ClienteRepository repository;
     
    public List<Cliente> findAll() {
        return repository.findAll();
    }
     
    public Cliente findOne(Long id) {
        return repository.getOne(id);
    }
     
    public Cliente save(Cliente cliente) {
        return repository.saveAndFlush(cliente);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public int contEncomenda() {
    	return repository.findAll().size();
    }

}
