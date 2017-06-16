package br.projetoH.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.projetoH.dao.ClienteDao;
import br.projetoH.model.Cliente;

public class ClienteController {
	public void salvar(String nome, String email) throws Exception{
		Cliente cli = new Cliente();
		cli.setNome(nome);
		cli.setEmail(email);
		
		new ClienteDao().salvar(cli);
	}
	
	public void alterar(int id, String nome, String email) throws Exception{
		Cliente cli = new Cliente();
		cli.setCod(id);
		cli.setNome(nome);
		cli.setEmail(email);
		
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
}
