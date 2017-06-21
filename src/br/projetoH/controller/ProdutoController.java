package br.projetoH.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.projetoH.dao.ProdutoDao;
import br.projetoH.model.Cliente;
import br.projetoH.model.Produto;

public class ProdutoController {
	private ArrayList<Produto> newList = new ArrayList<Produto>();
	public void salvar(String nome, int saldo) throws Exception{
		
		Produto prod = new Produto();
		prod.setNome(nome);
		prod.setSaldo(saldo);
		
		if(prod.getNome() == null){
			throw new Exception("Informar o nome do produto");
		}
		if(prod.getNome().trim().equals("")){
			throw new Exception("Informar o nome do produto");
		}
		
		if(prod.getSaldo()<=0){
			throw new Exception("O saldo deve ser maior do zero");
		}
		
		new ProdutoDao().salvar(prod);
	}
	
	public void alterar(int id, String nome, int saldo) throws Exception{
		Produto prod = new Produto();
		prod.setCod(id);
		prod.setNome(nome);
		prod.setSaldo(saldo);
		
		if(prod.getCod() == null){
			throw new Exception("O produto não foi instanciado");
		}
		
		if(prod.getNome() == null){
			throw new Exception("Informar o nome do produto");
		}
		if(prod.getNome().trim().equals("")){
			throw new Exception("Informar o nome do produto");
		}
		
		if(prod.getSaldo()<=0){
			throw new Exception("O saldo deve ser maior do zero");
		}
		
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
	public int buscarId2(int id) throws Exception{
		int check=0;
		this.newList = (ArrayList<Produto>) listarProdutos();
		for(int i=0; i<newList.size();i++){
			if(newList.get(i).getCod()== id){
				check=1;
				break;
			}else{
				check = 0;
			}
		}
		return check;
	}
}
