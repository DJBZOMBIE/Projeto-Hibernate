package br.projetoH.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name = "produto")
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer cod;
	
	private String nome;
	
	private int saldo;
	
	private Set<Item> itens = new HashSet<Item>(0);
	
	public Produto(){
		
	}
	public Produto(int saldo){
		this.saldo = saldo;
	}
	
	public Produto(String nome, int saldo, Set<Item> items) {
		this.nome = nome;
		this.saldo = saldo;
		this.itens = items;
	}
	@GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "optimizer", value = "none"),
			@Parameter(name = "sequence_name", value = "public.seq_produto"),
			@Parameter(name = "increment_size", value = "1") })
	@Id
	@GeneratedValue(generator = "generator")
	
	@Column(name = "cod", unique = true, nullable = false)
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	
	@Column(name = "nome", length = 50)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name = "saldo", nullable = false)
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	public Set<Item> getItens() {
		return itens;
	}
	public void setItens(Set<Item> itens) {
		this.itens = itens;
	}
	
}
