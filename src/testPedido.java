import java.util.ArrayList;

import br.projetoH.bi.PedidoBI;
import br.projetoH.bi.PedidoException;
import br.projetoH.dao.ClienteDao;
import br.projetoH.dao.ProdutoDao;
import br.projetoH.model.Cliente;
import br.projetoH.model.Item;
import br.projetoH.model.Produto;

public class testPedido {
	
	public static void main (String [] args){
		try{
			Cliente cliente = new Cliente();
			ClienteDao cli = new ClienteDao();
			cliente = cli.findById(1);
			ArrayList<Item> itens = new ArrayList<Item>();
			
			Produto produto = new Produto();
			ProdutoDao prod = new ProdutoDao();
			Item item1 = new Item();
			produto = prod.findById(4);
			item1.setProduto(produto);
			item1.setQuantidade(2);
			itens.add(item1);
			
			PedidoBI.createPedido(cliente, itens);
		}catch(PedidoException exception){
			System.out.println("Produto " + exception.getProduct().getNome() + " não tem saldo suficiente para a venda de " + exception.getQuantity() + " itens");
		}
	}
}
