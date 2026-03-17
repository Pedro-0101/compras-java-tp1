package Model.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import Model.Entities.Produto;

public class ProdutoDaoMemoria {
	
	private List<Produto> produtos=new ArrayList<>();
	
	public boolean salvar(Produto produto) {
		Produto p=buscar(produto.getId());
		if(p==null) {
			produtos.add(produto);
			return true;
		}
		return false;
	}
	
	public boolean remover(Produto produto) {
		int size=produtos.size();
		produtos.remove(produto);
		if(size>produtos.size())
			return true;
		return false;
	}
	
	public Produto buscar(long id) {
		for(Produto produto:produtos) {
			if(produto.getId()==id) {
				return produto;
			}
		}
		return null;
	}
	
	public void atualizar(Produto produto) {
		//ele atualiza por consequencia
	}
	
	public List<Produto> listar(){
		return produtos;
	}
	

}
