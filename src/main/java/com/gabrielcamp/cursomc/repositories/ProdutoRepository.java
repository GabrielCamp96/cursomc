package com.gabrielcamp.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielcamp.cursomc.domain.Produto;

// Responsável por trabalhar e consultar o BD (Repository)

// Integer no JpaRepository significa o TIPO do IDENTIFICADOR (PK)
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
}
