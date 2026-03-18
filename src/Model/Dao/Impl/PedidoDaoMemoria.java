package Model.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import Model.Entities.Pedido;

public class PedidoDaoMemoria {
	private List<Pedido> pedidos=new ArrayList<>();
	private Integer contador = 0;
	private Integer contadorSequencial = 0;
	
	public boolean salvar(Pedido pedido) {
		int size=pedidos.size();
		pedidos.add(pedido);
		contador++;
		contadorSequencial++;
		if(size<pedidos.size()) {
			return true;
		}
		return false;
	}
	
	public boolean remover(Pedido pedido) {
		int size=pedidos.size();
		pedidos.remove(pedido);
		contador--;
		if(size>pedidos.size()) {
			return true;
		}
		return false;
	}
	
	public Pedido buscar(long id) {
		for(Pedido pedido:pedidos) {
			if(pedido.getId()==id)
				return pedido;
		}
		return null;
	}
	
	public boolean atualizar(Pedido pedido) {
		return true;
	}
	
	public List<Pedido> listar(){
		return pedidos;
	}

	public Integer getContador() {
		return this.contador;
	}
	
	public Integer getContadorSequencial() {
		return this.contadorSequencial;
	}

}
