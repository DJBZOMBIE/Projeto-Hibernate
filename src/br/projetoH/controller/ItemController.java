package br.projetoH.controller;

import java.util.List;

import javax.swing.JOptionPane;

import br.projetoH.dao.ItemDao;
import br.projetoH.model.Item;


public class ItemController {
	
	public List<Item> listarItem() throws Exception{
		ItemDao dao = new ItemDao();
		try{
			return dao.findAll();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Problemas ao localizar itens!" + e.getLocalizedMessage());
		}
		return null;
	}
	
	public void excluir(int id) throws Exception{
		new ItemDao().excluir(id);
	}
	
	public Item buscarId(int id) throws Exception{
		ItemDao dao = new ItemDao();
		return dao.findById(id);
	}
}
