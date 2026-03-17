package View;

import Model.Dao.ProdutoDao;
import Model.Entities.Produto;
import View.Forms.FormProduto;
import View.auxiliar.LerOpcao;

public class ViewProduto {
	public static void main(String[] args) {

		ProdutoDao produtoDao = new ProdutoDao();

		LerOpcao lerOpcao = new LerOpcao();
		
		FormProduto formProduto = new FormProduto();

		int valorLido = 0;
		while ((valorLido = lerOpcao.mostrarMenueLer()) != 6) {

			switch (valorLido) {
			case 1: // inclusao
				
				Produto produtoInclusao = formProduto.processaInclusao();
				produtoDao.salvar(produtoInclusao);
				break;
				
			case 2: //remoção
				
				long id1 = formProduto.processaBusca();
				Produto produtoRemocao=produtoDao.buscar(id1);
				produtoDao.excluir(produtoRemocao);
				break;
				
			case 3: //busca
				
				long id2 = formProduto.processaBusca();
				Produto produtoBuscado=produtoDao.buscar(id2);
				formProduto.setProduto(produtoBuscado);
				formProduto.show("Busca");
				break;
				
			case 4: //atualização
				
				long id3 = formProduto.processaBusca();
				Produto produtoAtualizacao=produtoDao.buscar(id3);
				formProduto.setProduto(produtoAtualizacao);
				formProduto.processaAtualizacao();
				produtoDao.atualizar(produtoAtualizacao);
				break;
				
			case 5: //listar

				for (Produto p2 : produtoDao.listar()) {
					formProduto.setProduto(p2);
					formProduto.show("-----");
				}
				break;
			}

		}

	}

}
