package Model.Dao;


import Model.Dao.Impl.PedidoDaoMemoria;
import Model.Entities.Pedido;

import java.util.List;

public class PedidoDAO {
    private PedidoDaoMemoria pedidoDaoMemoria = new PedidoDaoMemoria();

    public void salvar(Pedido p){
        pedidoDaoMemoria.salvar(p);
    }

    public List<Pedido> listar(){
        return pedidoDaoMemoria.getLista();
    }

    public void remover(Pedido p){
        pedidoDaoMemoria.remove(p);
    }
}
