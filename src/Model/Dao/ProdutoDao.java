package Model.Dao;

import java.util.List;

import Model.Dao.Impl.ProdutoDaoMemoria;
import Model.Entities.Produto;

public class ProdutoDao {
	
	ProdutoDaoMemoria produtoDaoMem=new ProdutoDaoMemoria();
	
	public boolean salvar(Produto produto) {
		//abrir o banco de dados
		//fazer o sql de insercao no banco
		//verificar se o produto ja existe
		//se nao existe, inserir
		//se existe, emitir mensagem de erro
		
		if(produtoDaoMem.salvar(produto)) {
			System.out.println("Produto adicionado com sucesso!");
			return true;
		}else {
			System.out.println("Produto não pode ser salvo!");
		}
		return false;
	}
	
	public Produto buscar(long id) {
		Produto p=produtoDaoMem.buscar(id);
		if(p==null) {
			System.out.println("Produto não encontrado!");
		}
		return p;
		
	}
	
	public boolean excluir(Produto produto) {
		if(produtoDaoMem.remover(produto)) {
			System.out.println("Produto removido com sucesso!");
			return true;
		}
		return false;
	}
	
	public void atualizar(Produto produto) {
		Produto p=buscar(produto.getId());
		if(p!=null) { //update
			p.setId(produto.getId());
			p.setNome(produto.getNome());
			p.setPreco(produto.getPreco());
			produtoDaoMem.atualizar(produto);
		}
	}

	public List<Produto> listar(){
		return produtoDaoMem.listar();
	}
}
