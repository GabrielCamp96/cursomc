package com.gabrielcamp.cursomc.services;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielcamp.cursomc.domain.ItemPedido;
import com.gabrielcamp.cursomc.domain.Pedido;
import com.gabrielcamp.cursomc.domain.enums.EstadoPagamento;
import com.gabrielcamp.cursomc.domain.herancies.pagamentoComBoleto;
import com.gabrielcamp.cursomc.repositories.ItemPedidoRepository;
import com.gabrielcamp.cursomc.repositories.PagamentoRepository;
import com.gabrielcamp.cursomc.repositories.PedidoRepository;
import com.gabrielcamp.cursomc.repositories.ProdutoRepository;
import com.gabrielcamp.cursomc.services.exceptions.ObjectNotFoundException;

// Responsável por definir as consultas ao bd (Services)

@Service
public class PedidoService {

	// Para o Spring instanciar o objeto como injeção de dependencia ou inversão de controle
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private BoletoService boletoService;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException (
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	public @Valid Pedido insert(@Valid Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof pagamentoComBoleto) {
			pagamentoComBoleto pagto = (pagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		
		for(ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoRepository.findById(ip.getProduto().getId()).get().getPreco());
			ip.setPedido(obj);
		}
		
		itemPedidoRepository.saveAll(obj.getItens());
		
		return obj;
		
	}
	
}
