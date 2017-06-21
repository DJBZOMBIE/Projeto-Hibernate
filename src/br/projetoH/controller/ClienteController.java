package br.projetoH.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.projetoH.dao.ClienteDao;
import br.projetoH.model.Cliente;
import br.projetoH.model.Produto;

public class ClienteController {
	private ArrayList<Cliente> newList = new ArrayList<Cliente>();
	public void salvar(String nome, String email) throws Exception{
		Cliente cli = new Cliente();
		cli.setNome(nome);
		cli.setEmail(email);
		
		if(cli.getNome() == null){
			throw new Exception("Informar o nome do cliente");
		}
		if(cli.getNome().trim().equals("")){
			throw new Exception("Informar o nome do cliente");
		}
		if(cli.getEmail() == null){
			throw new Exception("Informar o email do cliente");
		}
		if(cli.getEmail().trim().equals("")){
			throw new Exception("Informar o email do cliente");
		}
		
		new ClienteDao().salvar(cli);
	}
	
	public void alterar(int id, String nome, String email) throws Exception{
		Cliente cli = new Cliente();
		cli.setCod(id);
		cli.setNome(nome);
		cli.setEmail(email);
		
		
		if(cli.getCod() == null){
			throw new Exception("O cliente não foi instanciado");
		}
		if(cli.getCod()<0){
			throw new Exception("O código do cliente não pode ser negativo");
		}
		if(cli.getNome() == null){
			throw new Exception("Informar o nome do cliente");
		}
		if(cli.getNome().trim().equals("")){
			throw new Exception("Informar o nome do cliente");
		}
		if(cli.getEmail() == null){
			throw new Exception("Informar o email do cliente");
		}
		if(cli.getEmail().trim().equals("")){
			throw new Exception("Informar o email do cliente");
		}
		
		new ClienteDao().alterar(cli);
	}
	
	public List<Cliente> listarClientes() throws Exception{
		ClienteDao dao = new ClienteDao();
		try{
			return dao.findAll();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Problemas ao localizar cliente!" + e.getLocalizedMessage());
		}
		return null;
	}
	
	public void excluir(int id) throws Exception{
		
		new ClienteDao().excluir(id);
	}
	public Cliente buscarClientePorNome(String nome) throws Exception{
		ClienteDao dao = new ClienteDao();
		return dao.findByName(nome);
	}
	public int buscarId(int id) throws Exception{
		int check=0;
		this.newList = (ArrayList<Cliente>) listarClientes();
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
