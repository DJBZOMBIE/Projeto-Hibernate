package br.projetoH.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.projetoH.dao.ItemDao;
import br.projetoH.model.Cliente;
import br.projetoH.model.Item;


public class ItemController {
	private ArrayList<Item> newList = new ArrayList<Item>();
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
	
	public int buscarId2(int id) throws Exception{
		int check=0;
		this.newList = (ArrayList<Item>) listarItem();
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
