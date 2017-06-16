package br.projetoH.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.projetoH.dao.ProdutoDao;
import br.projetoH.model.Produto;

public class ProdutoController {
	public void salvar(String nome, int saldo) throws Exception{
		Produto prod = new Produto();
		prod.setNome(nome);
		prod.setSaldo(saldo);
		
		new ProdutoDao().salvar(prod);
	}
	
	public void alterar(int id, String nome, int saldo) throws Exception{
		Produto prod = new Produto();
		prod.setCod(id);
		prod.setNome(nome);
		prod.setSaldo(saldo);
		
		new ProdutoDao().alterar(prod);
	}
	
	public List<Produto> listarProdutos() throws Exception{
		ProdutoDao dao = new ProdutoDao();
		
		try{
			return dao.findAll();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Problemas ao localizar produto!" + e.getLocalizedMessage());
		}
		return null;
	}
	
	public void excluir(int id) throws Exception{
		new ProdutoDao().excluir(id);
	}
	
	public Produto buscarProdutoPorNome(String nome) throws Exception{
		ProdutoDao dao = new ProdutoDao();
		return dao.findByName(nome);
	}
	
	public Produto buscarId(int id)throws Exception{
		ProdutoDao dao = new ProdutoDao();
		return dao.findById(id);
	}
}
