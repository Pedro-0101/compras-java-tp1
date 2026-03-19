package Model.Dao.Impl;

import Model.Entities.Pedido;
import Model.Entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDaoMemoria {
    private List<Produto> lista = new ArrayList<>();
    private Long contador;

    public ProdutoDaoMemoria(){
        this.contador = 1L;
    }

    public void salvar(Produto p){
        p.setId(contador++);
        lista.add(p);
    }

    public boolean remove(Produto produto){
        int tamanhoListaAntes = lista.size();
        lista.remove(produto);
        return tamanhoListaAntes != lista.size();
    }

    public Produto buscar(Long id){
        return lista.stream().filter(produto -> produto.getId().equals(id))
                .findFirst().orElse(null);
    }

    public List<Produto> getLista() {
        return lista;
    }

    public void setLista(List<Produto> lista) {
        this.lista = lista;
    }

    public Long getContador() {
        return contador;
    }

    public void setContador(Long contador) {
        this.contador = contador;
    }
}
