package View.Menu;

import Core.ConsoleUI;
import Model.Dao.ProdutoDAO;
import Model.Entities.Produto;
import View.Form.ProductForm;
import java.util.List;

public class ProductMenu {
    private final ConsoleUI ui;
    private final ProdutoDAO produtoDAO;
    private final ProductForm form;

    public ProductMenu(ConsoleUI ui, ProdutoDAO produtoDAO) {
        this.ui = ui;
        this.produtoDAO = produtoDAO;
        this.form = new ProductForm(ui);
    }

    public void show() {
        int option;
        do {
            ui.header("Gerenciar Produtos");
            ui.display("1. Adicionar");
            ui.display("2. Listar");
            ui.display("3. Editar");
            ui.display("4. Excluir");
            ui.display("0. Voltar");
            option = ui.readInt("Opção: ");

            switch (option) {
                case 1: add(); break;
                case 2: list(); break;
                case 3: edit(); break;
                case 4: delete(); break;
                case 0: break;
                default: ui.display("Opção inválida!");
            }
        } while (option != 0);
    }

    private void add() {
        Produto p = form.create();
        produtoDAO.salvar(p);
        ui.display("Produto salvo com sucesso! ID: " + p.getId());
    }

    private void list() {
        form.list(produtoDAO.lista());
    }

    private void edit() {
        int id = ui.readInt("ID do produto para editar: ");
        Produto p = findById(id);
        if (p != null) {
            form.update(p);
            ui.display("Produto atualizado!");
        } else {
            ui.display("Produto não encontrado.");
        }
    }

    private void delete() {
        int id = ui.readInt("ID do produto para excluir: ");
        Produto p = findById(id);
        if (p != null) {
            produtoDAO.remover(p);
            ui.display("Produto removido!");
        } else {
            ui.display("Produto não encontrado.");
        }
    }

    private Produto findById(int id) {
        List<Produto> lista = produtoDAO.lista();
        for (Produto p : lista) {
            if (p.getId().intValue() == id) return p;
        }
        return null;
    }
}
