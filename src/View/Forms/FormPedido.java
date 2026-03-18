package View.Forms;

import java.util.Scanner;
import java.time.Instant;
import java.sql.Timestamp;

import Model.Entities.ItemPedido;
import Model.Entities.Pedido;
import Model.Entities.Produto;

public class FormPedido {
	
	Pedido pedido;
	
	Scanner leitor=new Scanner(System.in);
	
	public void setPedido(Pedido pedido) {
		this.pedido=pedido;
	}
	
	public void show(String cabecalho) {
		System.out.println("===="+cabecalho+"=====");
	
		System.out.println("Pedido id: "+pedido.getId());
		System.out.println("Pedido data: "+pedido.getDate());
		System.out.println("Pedido total: "+pedido.calcularTotal());
	}
	
	public Pedido processaInclusao(Integer id) {
		System.out.println("===INCLUSÂO===");

		Pedido pedido=new Pedido();
		
		Instant instant = Instant.now();
		String date = instant.toString();
		Long pedidoId = (long) id;
		Double total =  0.00;

		pedido.setId(pedidoId);
		pedido.setDate(date);
		pedido.setValorTotal(total);

		return pedido;
		
	}
	
	/*public void processaAtualizacao() {
		System.out.println("===ATUALIZAÇÂO===");

		Produto p=new Produto();
		
		
		System.out.println("Produto id:"+produto.getId()); 
		//long id=leitor.nextLong();
		
		System.out.println("Produto nome:");
		String nome=leitor.next();
		
		System.out.println("Produto preço:");
		double preco=leitor.nextDouble();
		
		produto.setId(produto.getId());
		produto.setNome(nome);
		produto.setPreco(preco);
		
	}
	
	
	
	public long processaBusca() {
		System.out.println("===REMOÇÂO===");

		
		System.out.println("Digite a id do produto a ser removido:");
		System.out.println("Produto id:"); 
		long id=leitor.nextLong();
		
		return id;
	}*/
	

}
