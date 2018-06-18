package com.br.catolicasc.muitomaisbarato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.br.catolicasc.muitomaisbarato.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{ }
