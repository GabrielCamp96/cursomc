package com.gabrielcamp.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielcamp.cursomc.domain.Cliente;

// Responsável por trabalhar e consultar o BD (Repository)

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
}
