package Model.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import Model.Entities.Pedido;

public class PedidoDaoMemoria {
	private List<Pedido> pedidos=new ArrayList<>();
	
	public boolean salvar(Pedido pedido) {
		int size=pedidos.size();
		pedidos.add(pedido);
		if(size<pedidos.size()) {
			return true;
		}
		return false;
	}
	
	public boolean remover(Pedido pedido) {
		int size=pedidos.size();
		pedidos.remove(pedido);
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

	
	

}
