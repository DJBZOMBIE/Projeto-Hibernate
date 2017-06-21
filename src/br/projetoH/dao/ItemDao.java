package br.projetoH.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	
	@SuppressWarnings("unchecked")
	public ArrayList<Item> listarItensP(int itens){
		String hql = "SELECT cod, cod_pedido, cod_produto, quantidade FROM item WHERE cod_pedido = '"+itens+"'";
		Query query = entityManager.createQuery(hql);
		query.setParameter("listarItensP", itens);
		
		return (ArrayList<Item>) query.getResultList();
	}
}
