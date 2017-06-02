package br.projetoH.dao;

import javax.persistence.EntityManager;

import br.projetoH.model.Pedido;
import br.projetoH.model.Produto;

public class PedidoDao extends GenericDao<Pedido>{
	
	public PedidoDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PedidoDao(EntityManager entityManager) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void salvar(Pedido ped){
		save(ped);
	}
	
	public void alterar(Pedido ped){
		update(ped);
	}
	
	public void excluir(int id){
		Pedido p = findById(id);
		delete(p);
	}
}
