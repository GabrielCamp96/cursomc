package com.gabrielcamp.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielcamp.cursomc.domain.ItemPedido;
import com.gabrielcamp.cursomc.domain.ItemPedidoPK;

// Responsável por trabalhar e consultar o BD (Repository)

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK>{
	
}
