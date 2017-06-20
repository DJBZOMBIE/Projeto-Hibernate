package br.projetoH.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class PedidoTableModel extends DefaultTableModel{
	private ArrayList<Pedido> internalList;
	private String[] header = new String[]{"Código", "Data","Cod_Cliente"};
	
	public PedidoTableModel(ArrayList<Pedido> newList){
		this.internalList = newList;
	}
	
	public Pedido getElementAt(int index){
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
	
	public Pedido getPedidoAt(int row){
		return internalList.get(row);
	}
}
