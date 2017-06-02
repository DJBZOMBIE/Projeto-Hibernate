import br.projetoH.dao.ProdutoDao;
import br.projetoH.model.Produto;

public class testProduto {
	public static void main (String[] args){
		Produto prod = new Produto();
		
		prod.setNome("Playstation 3");
		prod.setSaldo(10);
		new ProdutoDao().salvar(prod);
	}
}
