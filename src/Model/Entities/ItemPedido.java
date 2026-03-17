package Model.Entities;

public class ItemPedido {
	
	private Produto produto; 
	private double quantidade;

	
	//===============
	public double subTotal() {
		return produto.getPreco()*quantidade;
	}
	//===============
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
}
