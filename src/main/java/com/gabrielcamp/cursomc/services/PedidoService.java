package com.gabrielcamp.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielcamp.cursomc.domain.Pedido;
import com.gabrielcamp.cursomc.repositories.PedidoRepository;

import com.gabrielcamp.cursomc.services.exceptions.ObjectNotFoundException;

// Responsável por definir as consultas ao bd (Services)

@Service
public class PedidoService {

	// Para o Spring instanciar o objeto como injeção de dependencia ou inversão de controle
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException (
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
}
