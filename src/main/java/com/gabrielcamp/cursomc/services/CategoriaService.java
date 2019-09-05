package com.gabrielcamp.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielcamp.cursomc.domain.Categoria;
import com.gabrielcamp.cursomc.repositories.CategoriaRepository;

// Responsável por definir as consultas ao bd (Services)

@Service
public class CategoriaService {

	// Para o Spring instanciar o objeto como injeção de dependencia ou inversão de controle
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
