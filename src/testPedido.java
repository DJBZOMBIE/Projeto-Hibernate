import java.util.ArrayList;

import br.projetoH.bi.PedidoBI;
import br.projetoH.bi.PedidoException;
import br.projetoH.controller.ClienteController;
import br.projetoH.controller.ProdutoController;
import br.projetoH.dao.ClienteDao;
import br.projetoH.dao.ProdutoDao;
import br.projetoH.model.Cliente;
import br.projetoH.model.Item;
import br.projetoH.model.Produto;

public class testPedido {
	
	public static void main (String [] args) throws Exception{
		ClienteController clienteC = new ClienteController();
		ProdutoController prodC = new ProdutoController();
		try{
			Cliente cliente = new Cliente();
			ClienteDao cli = new ClienteDao();
			ArrayList<Item> itens = new ArrayList<Item>();
			Produto produto = new Produto();
			ProdutoDao prod = new ProdutoDao();
			Item item1 = new Item();
			if(clienteC.buscarId(3) == 1){
				cliente = cli.findById(3);
				
			}else{
				throw new Exception("Erro pedido");
				
			}
			if(prodC.buscarId2(4)==1){
				produto = prod.findById(4);
			}else{
				throw new Exception("Erro produto");
			}
			
			item1.setProduto(produto); //item recebe id do produto
			item1.setQuantidade(2); //quantidade de itens
			itens.add(item1);
			//PedidoBI.createPedido(cliente, itens);
		}catch(PedidoException exception){
			System.out.println("Produto " + exception.getProduct().getNome() + " não tem saldo suficiente para a venda de " + exception.getQuantity() + " itens");
		}
	}
}
