package com.br.catolicasc.muitomaisbarato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.catolicasc.muitomaisbarato.models.ListaCompras;

import com.br.catolicasc.muitomaisbarato.repository.ListaDeComprasRepository;

@Service
public class ListaDeComprasService {
	@Autowired
    private ListaDeComprasRepository repository;
     
    public List<ListaCompras> findAll() {
        return repository.findAll();
    }
     
    public ListaCompras findOne(Long id) {
        return repository.getOne(id);
    }
     
    public ListaCompras save(ListaCompras listaCompras) {
        return repository.saveAndFlush(listaCompras);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public int contEncomenda() {
    	return repository.findAll().size();
    }
}
