package br.projetoH.bi;

import br.projetoH.model.Produto;

public class PedidoException extends Exception {
	private static final long serialVersionUID = 1L;
	private Produto product;
	
	private int quantity;
	
	public PedidoException(Produto product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public PedidoException() {
		// TODO Auto-generated constructor stub
	}

	public Produto getProduct() {
		return product;
	}

	public void setProduct(Produto product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
