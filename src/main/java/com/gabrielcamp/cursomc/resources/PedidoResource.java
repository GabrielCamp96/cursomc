package com.gabrielcamp.cursomc.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielcamp.cursomc.domain.Pedido;
import com.gabrielcamp.cursomc.services.PedidoService;

// Responsável por instanciar e popular os objetos (Resource - Controlador REST)

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
//		Implementação inicial para testar REST
//
//		Pedido cat1 = new Pedido(1, "Informática");
//		Pedido cat2 = new Pedido(2, "Escritório");
//		
//		List<Pedido> lista = new ArrayList<Pedido>();
//		lista.add(cat1);
//		lista.add(cat2);
//		
//		return lista;		
		
	}
}
