package br.projetoH.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ItemTableModel extends DefaultTableModel {
	private ArrayList<Item> internalList;
	private String[] header = new String[]{"ID", "Cod_pedido","Cod_produto","Quantidade"};
	
	public ItemTableModel(ArrayList<Item>newList){
		this.internalList = newList;
	}
	
	public Item getElementAt(int index){
		return internalList.get(index);
	}
	
	public int getSize() {
		return internalList.size();
	}
	
	public int getRouCount(){
		if(internalList == null){
			return 0;
		}
		return internalList.size(); // quantidade de objetos/linhas na tabela
	}
	
	public int getColumnCount(){
		return header.length;
	}
	
	public String getColumnName(int column){
		return header[column];
	}
	
	
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		
		return false;
	}
	
	public Item getItemAt(int row){
		return internalList.get(row);
	}
}
