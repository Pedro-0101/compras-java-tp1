package Model.Dao;

import Model.Dao.Impl.ProdutoDaoMemoria;
import Model.Entities.Produto;

import java.util.List;

public class ProdutoDAO {
    private ProdutoDaoMemoria produtoDaoMemoria = new ProdutoDaoMemoria();

    public void salvar(Produto p){
        produtoDaoMemoria.salvar(p);
    }

    public Produto buscar(Long id){
        Produto produto = produtoDaoMemoria.buscar(id);
        if(produto != null){
            System.out.println("Produto encontrado: " + produto.getNome() + " - R$ " + produto.getPreco());
        } else {
            System.out.println("Produto não encontrado.");
        }
        return produto;
    }

    public List<Produto> lista(){
        return produtoDaoMemoria.getLista();
    }

    public boolean remover(Produto p){
        return produtoDaoMemoria.remove(p);
    }
}
