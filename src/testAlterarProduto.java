import br.projetoH.dao.ProdutoDao;
import br.projetoH.model.Produto;

public class testAlterarProduto {
	public static void main(String[] args){
		Produto prod = new Produto();
		
		prod.setCod(100);
		prod.setNome("PS4");
		prod.setSaldo(12);
		
		new ProdutoDao().alterar(prod);
	}
}
