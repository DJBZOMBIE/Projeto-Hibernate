package br.projetoH.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item", schema = "public")

public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cod", unique = true, nullable = false)
	private Integer cod;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_pedido")
	private Pedido pedido;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_produto")
	private Produto produto;
	@Column(name = "quantidade")
	private Integer quantidade;
	
	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Item(){
		
	}
	
	public Item(Pedido pedido, Produto produto, Integer quantidade){
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
}
