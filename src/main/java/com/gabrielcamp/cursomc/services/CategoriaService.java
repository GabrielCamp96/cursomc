package com.gabrielcamp.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gabrielcamp.cursomc.domain.Categoria;
import com.gabrielcamp.cursomc.repositories.CategoriaRepository;
import com.gabrielcamp.cursomc.services.exceptions.DataIntegrityException;
import com.gabrielcamp.cursomc.services.exceptions.ObjectNotFoundException;

// Responsável por definir as consultas ao bd (Services)

@Service
public class CategoriaService {

	// Para o Spring instanciar o objeto como injeção de dependencia ou inversão de
	// controle
	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categora que possui produtos.");
		}
	}

}
