package br.projetoH.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ProdutoTableModel extends DefaultTableModel{
	
	private ArrayList<Produto> internalList;
	private String[] header = new String[] {"ID", "Nome", "Saldo", "Código de Barras"};
	
	public ProdutoTableModel(ArrayList<Produto> newList){
		this.internalList = newList;
	}
	
	public Produto getElementAt(int index){
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
	public Produto getProdutoAt(int row) {
		
		return internalList.get(row);
	}
}
