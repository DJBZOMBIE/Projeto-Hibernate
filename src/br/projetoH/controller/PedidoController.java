package br.projetoH.controller;

import java.util.List;

import javax.swing.JOptionPane;

import br.projetoH.dao.PedidoDao;
import br.projetoH.model.Pedido;

public class PedidoController {
	
	public void salvar(Pedido ped){
		
		if(ped.getCod() == null){
			JOptionPane.showMessageDialog(null, "Pedido n�o instanciado");
		}
		if(ped.getData().equals("")){
			JOptionPane.showMessageDialog(null, "O campo data esta vazio");
		}
		if(ped.getCliente()==null){
			JOptionPane.showMessageDialog(null, "O cod_cliente esta vazio");
		}
		
		new PedidoDao().salvar(ped);
	}
	
	public void alterar(Pedido ped){
		if(ped.getCod() == null){
			JOptionPane.showMessageDialog(null, "Pedido n�o instanciado");
		}
		if(ped.getData().equals("")){
			JOptionPane.showMessageDialog(null, "O campo data esta vazio");
		}
		if(ped.getCliente()==null){
			JOptionPane.showMessageDialog(null, "O cod_cliente esta vazio");
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
}