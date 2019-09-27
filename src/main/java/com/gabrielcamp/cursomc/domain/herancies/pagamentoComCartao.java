package com.gabrielcamp.cursomc.domain.herancies;


import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.gabrielcamp.cursomc.domain.Pagamento;
import com.gabrielcamp.cursomc.domain.Pedido;
import com.gabrielcamp.cursomc.domain.enums.EstadoPagamento;

@Entity
@JsonTypeName("pagamentoComCartao")
public class pagamentoComCartao extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
	public pagamentoComCartao() {
		
	}

	public pagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}	
	
}
