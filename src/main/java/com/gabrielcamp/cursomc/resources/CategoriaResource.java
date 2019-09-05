package com.gabrielcamp.cursomc.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielcamp.cursomc.domain.Categoria;
import com.gabrielcamp.cursomc.services.CategoriaService;

// Responsável por instanciar e popular os objetos (Resource - Controlador REST)

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
//		Implementação inicial para testar REST
//
//		Categoria cat1 = new Categoria(1, "Informática");
//		Categoria cat2 = new Categoria(2, "Escritório");
//		
//		List<Categoria> lista = new ArrayList<Categoria>();
//		lista.add(cat1);
//		lista.add(cat2);
//		
//		return lista;		
		
	}
}
