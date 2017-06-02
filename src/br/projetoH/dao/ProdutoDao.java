package br.projetoH.dao;

import javax.persistence.EntityManager;

import br.projetoH.model.Produto;

public class ProdutoDao extends GenericDao<Produto>{
	public ProdutoDao(){
		super();
	}
	public ProdutoDao(EntityManager entityManager) {
		super();
	}

	public void salvar(Produto produto){
		save(produto);
	}
	
	public void alterar(Produto produto){
		update(produto);
	}
	
	public void excluir(int id){
		Produto p = findById(id);
		delete(p);
	}
}
