package Model.Dao;

import java.util.List;

import Model.Dao.Impl.PedidoDaoMemoria;
import Model.Entities.ItemPedido;
import Model.Entities.Pedido;

public class PedidoDao {
	
	PedidoDaoMemoria pedidoDao=new PedidoDaoMemoria();
	
	public boolean salvar(Pedido pedido) {
		if(pedidoDao.salvar(pedido)) {
			System.out.println("Pedido salvo!");
			return true;
		}else System.out.println("Pedido não foi salvo!");
		return false;
	}
	
	public boolean remover(Pedido pedido) {
		Pedido p=buscar(pedido.getId());
		if(p!=null) {
			pedidoDao.remover(pedido);
			System.out.println("Pedido removido!");
			return true;
		}
		System.out.println("Pedido não existe!");
		return false;
		
	}
	
	public Pedido buscar(long id) {
		Pedido p=pedidoDao.buscar(id);
		if(p!=null) {
			return p;
		}
		return p;
		
	}
	
	public boolean atualizar(Pedido pedido) {
		Pedido p=pedidoDao.buscar(pedido.getId());
		if(p!=null) {
			p.setId(pedido.getId());
			p.setDate(pedido.getDate());
			p.setValorTotal(pedido.getValorTotal());
			//List<ItemPedido> itens=pedido.getItens();
			return true;
		}
		return false;		
	}
	
	public List<Pedido> listar(){
		return pedidoDao.listar();
	}

}
