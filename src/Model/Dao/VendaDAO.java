package Model.Dao;

import Model.Dao.Impl.VendaDaoMemoria;
import Model.Entities.Venda;

import java.util.List;

public class VendaDAO {
    private VendaDaoMemoria vendaDaoMemoria = new VendaDaoMemoria();

    public void salvar(Venda v){
        vendaDaoMemoria.salvar(v);
    }

    public List<Venda> listar(){
        return vendaDaoMemoria.getLista();
    }

    public void remover(Venda v){
        vendaDaoMemoria.remove(v);
    }
}
