package Model.Dao.Impl;

import Model.Entities.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaDaoMemoria {
    private List<Venda> lista = new ArrayList<>();
    private Long contador;

    public VendaDaoMemoria(){
        this.contador = 1L;
    }

    public void salvar(Venda v){
        v.setId(contador++);
        lista.add(v);
    }

    public void remove(Venda venda){
        lista.remove(venda);
    }

    public List<Venda> getLista() {
        return lista;
    }

    public void setLista(List<Venda> lista) {
        this.lista = lista;
    }

    public Long getContador() {
        return contador;
    }

    public void setContador(Long contador) {
        this.contador = contador;
    }
}
