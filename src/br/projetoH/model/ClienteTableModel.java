package br.projetoH.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ClienteTableModel extends DefaultTableModel {
	private ArrayList<Cliente> internalList;
	private String[] header = new String[] {"Cod", "Nome", "email"};
	
	public ClienteTableModel(ArrayList<Cliente> newList){
		this.internalList = newList;
	}
	public Cliente getElementAt(int index){
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
	public Cliente getClientAt(int row) {
		return internalList.get(row);
	}
}
