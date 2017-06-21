package br.projetoH.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.projetoH.dao.PedidoDao;
import br.projetoH.model.Pedido;

public class PedidoController {
	private ArrayList<Pedido> newList = new ArrayList<Pedido>();
	public void salvar(Pedido ped) throws Exception{
		
		if(ped.getData().equals("")){
			throw new Exception("O campo data esta vazio");
		}
		if(ped.getCliente()==null){
			throw new Exception("O cod_cliente esta vazio");
		}
		
		new PedidoDao().salvar(ped);
	}
	
	public void alterar(Pedido ped)throws Exception{
		if(ped.getCod() == null){
			throw new Exception("Pedido não instanciado");
		}
		if(ped.getData().equals("")){
			throw new Exception("O campo data esta vazio");
		}
		if(ped.getCliente()==null){
			throw new Exception("O cod_cliente esta vazio");
		}
		new PedidoDao().alterar(ped);
	}
	
	public List<Pedido> listarPedido() throws Exception{
		PedidoDao dao = new PedidoDao();
		try{
			return dao.findAll();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Problemas ao localizar pedido!" + e.getLocalizedMessage());
		}
		return null;
	}
	
	public void excluir(int id) throws Exception{
		new PedidoDao().excluir(id);
	}
	
	public Pedido buscarId(int id) throws Exception{
		PedidoDao dao = new PedidoDao();
		return dao.findById(id);
	}
	
	public int buscarId2(int id) throws Exception{
		int check=0;
		this.newList = (ArrayList<Pedido>) listarPedido();
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
