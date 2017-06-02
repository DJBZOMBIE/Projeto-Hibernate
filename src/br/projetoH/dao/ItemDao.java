package br.projetoH.dao;

import javax.persistence.EntityManager;

import br.projetoH.model.Item;
import br.projetoH.model.Pedido;

public class ItemDao extends GenericDao<Item>{
	public ItemDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemDao(EntityManager entityManager) {
		super();
	}
	
	public void salvar(Item it){
		save(it);
	}
	
	public void alterar(Item it){
		update(it);
	}
	
	public void excluir(int id){
		Item i = findById(id);
		delete(i);
	}
}
