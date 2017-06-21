package br.projetoH.bi;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.projetoH.dao.ItemDao;
import br.projetoH.dao.PedidoDao;
import br.projetoH.dao.ProdutoDao;
import br.projetoH.model.Cliente;
import br.projetoH.model.Item;
import br.projetoH.model.Pedido;
import br.projetoH.model.Produto;

public class PedidoBI {
	
	public static void createPedido(Cliente cliente, ArrayList<Item> itens) throws PedidoException{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja2");
		
		EntityManager entityManager = factory.createEntityManager();
		
		try{
			entityManager.getTransaction().begin();
			
			//inserir pedido
			PedidoDao pedidoDao = new PedidoDao(entityManager);
			
			Pedido ped = new Pedido();
			ped.setCliente(cliente);
			ped.setData(new Date());
		
			pedidoDao.salvar(ped);
			
			//System.out.println("Pedido de número " + ped.getCod() + " criado");
			JOptionPane.showMessageDialog(null, "Pedido de número " + ped.getCod() + " criado");
			// Foreach nos Itens, inserindo cada um dos itens
			ItemDao itemDao = new ItemDao(entityManager);
			ProdutoDao prodDao = new ProdutoDao(entityManager);
			for (Item item: itens){
				Produto prod = item.getProduto();
				
				if(prod.getSaldo() >= item.getQuantidade()){
					item.setPedido(ped);
					itemDao.salvar(item);
					
					prod.setSaldo(prod.getSaldo() - item.getQuantidade());
					prodDao.alterar(prod);
				}else{
					throw new PedidoException(prod, item.getQuantidade());
				}
			}
			//comit
			entityManager.getTransaction().commit();
		}finally{
			entityManager.close();
		}
	}
}
