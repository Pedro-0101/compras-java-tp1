package Model.Entities;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private long id;
	private String date;
	private double valorTotal=0;
	
	//=======PEDIDO ITENS
	private List<ItemPedido> itens=new ArrayList<>();
	
	public void addItem(ItemPedido item) {
		itens.add(item);
	}
	
	public void removeItem(ItemPedido item) {
		itens.remove(item);
	}
	
	public double calcularTotal() {
		double soma=0;
		for(ItemPedido item:itens) {
			soma+=item.subTotal();
		}
		valorTotal=soma;
		return valorTotal;
	}
    //======
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
	

}
