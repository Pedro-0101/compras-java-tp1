package View.Forms;

import java.util.Scanner;

import Model.Entities.Produto;

public class FormProduto {
	
	Produto produto;
	
	Scanner leitor=new Scanner(System.in);
	
	public void setProduto(Produto produto) {
		this.produto=produto;
	}
	
	public void show(String cabecalho) {
		System.out.println("===="+cabecalho+"=====");
	
		System.out.println("Produto id:"+produto.getId());
		System.out.println("Produto nome:"+produto.getNome());
		System.out.println("Produto preço:"+produto.getPreco());
	}
	
	public Produto processaInclusao() {
		System.out.println("===INCLUSÂO===");

		Produto p=new Produto();
		
		
		System.out.println("Produto id:"); 
		long id=leitor.nextLong();
		
		System.out.println("Produto nome:");
		String nome=leitor.next();
		
		System.out.println("Produto preço:");
		double preco=leitor.nextDouble();
		
		p.setId(id);
		p.setNome(nome);
		p.setPreco(preco);
		
		return p;
		
	}
	
	public void processaAtualizacao() {
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
	}
	

}
