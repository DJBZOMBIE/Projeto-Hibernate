package br.projetoH.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedido", schema = "public")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cod", unique = true, nullable = false)
	private Integer cod;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_cliente") //faz um join na tabela pedido e cliente
	private Cliente cliente;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", length = 35)
	private Date data;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	private Set<Item> itens = new HashSet<Item>(0);
	
	public Pedido(){
		
	}
	
	public Pedido(Cliente cliente, Date data, Set<Item> itens){
		this.cliente = cliente;
		this.data = data;
		this.itens = itens;
	}
	
	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Set<Item> getItens() {
		return itens;
	}

	public void setItens(Set<Item> itens) {
		this.itens = itens;
	}

	
}
