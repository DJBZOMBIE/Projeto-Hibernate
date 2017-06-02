import br.projetoH.dao.ProdutoDao;
import br.projetoH.model.Produto;

public class testListarProduto {
	public static void main(String[] args) throws Exception{
		ProdutoDao prodDao = new ProdutoDao();
		java.util.List<Produto> listProd = prodDao.findAll();
		
		for(Produto prod : listProd){
			System.out.println("Produto: " + prod.getNome() + " | Saldo: " + prod.getSaldo());
		}
	}
}
