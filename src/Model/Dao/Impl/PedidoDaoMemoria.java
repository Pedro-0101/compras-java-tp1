package Model.Dao.Impl;

import Model.Entities.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoDaoMemoria {
    private List<Pedido> lista = new ArrayList<>();
    private Long contador;

    public PedidoDaoMemoria(){
        this.contador = 1L;
    }

    public void salvar(Pedido p){
        p.setId(contador++);
        lista.add(p);
    }

    public void remove(Pedido pedido){
        lista.remove(pedido);
    }



    public List<Pedido> getLista() {
        return lista;
    }

    public void setLista(List<Pedido> lista) {
        this.lista = lista;
    }

    public Long getContador() {
        return contador;
    }

    public void setContador(Long contador) {
        this.contador = contador;
    }
}
