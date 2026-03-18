package View.Forms;

import java.util.Scanner;

import Model.Dao.ProdutoDao;
import Model.Entities.ItemPedido;
import Model.Entities.Produto;

public class FormItemPedido {
	
	ItemPedido itemPedido;
	
	Scanner leitor=new Scanner(System.in);
	
	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido=itemPedido;
	}
	
	public void show(String cabecalho) {
		System.out.println("===="+cabecalho+"=====");
	
		System.out.println("Produto id:"+itemPedido.getProduto().getId());
		System.out.println("Produto quantidade:"+itemPedido.getQuantidade());
		System.out.println("Produto preço:"+itemPedido.getProduto().getPreco());
	}
	
	public ItemPedido processaInclusao() {
		System.out.println("===INCLUSÂO===");

		ItemPedido itemPedido = new ItemPedido();
		
		
		System.out.println("Produto id:"); 
		long id=leitor.nextLong();
		
		System.out.println("Produto quantidade:");
		Integer quantidade=leitor.nextInt();

		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.buscar(id);
		
		itemPedido.setProduto(produto);
		itemPedido.setQuantidade(quantidade);
		
		return itemPedido;
		
	}	

}
