package com.br.catolicasc.muitomaisbarato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.catolicasc.muitomaisbarato.models.Produto;

import com.br.catolicasc.muitomaisbarato.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
    private ProdutoRepository repository;
     
    public List<Produto> findAll() {
        return repository.findAll();
    }
     
    public Produto findOne(Long id) {
        return repository.getOne(id);
    }
     
    public Produto save(Produto produto) {
        return repository.saveAndFlush(produto);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public int contProduto() {
    	return repository.findAll().size();
    }

}
