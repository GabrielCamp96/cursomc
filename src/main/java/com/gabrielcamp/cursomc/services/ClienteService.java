package com.gabrielcamp.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielcamp.cursomc.domain.Cliente;
import com.gabrielcamp.cursomc.repositories.ClienteRepository;

import com.gabrielcamp.cursomc.services.exceptions.ObjectNotFoundException;

// Responsável por definir as consultas ao bd (Services)

@Service
public class ClienteService {

	// Para o Spring instanciar o objeto como injeção de dependencia ou inversão de controle
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException (
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
}
