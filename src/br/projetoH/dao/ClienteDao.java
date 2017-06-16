package br.projetoH.dao;

import javax.persistence.EntityManager;

import br.projetoH.model.Cliente;
import br.projetoH.model.Produto;

public class ClienteDao extends GenericDao<Cliente>{
	public ClienteDao(){
		super();
	}
	public ClienteDao(EntityManager entityManager){
		super();
	}
	public void salvar(Cliente cliente){
		save(cliente);
	}
	
	public void alterar(Cliente cliente){
		update(cliente);
	}
	public void excluir(int id){
		Cliente c = findById(id);
		delete(c);
	}
}
