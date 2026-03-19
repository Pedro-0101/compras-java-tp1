package View.Form;

import Core.ConsoleUI;
import Model.Entities.Produto;
import java.util.List;

public class ProductForm {
    private final ConsoleUI ui;

    public ProductForm(ConsoleUI ui) {
        this.ui = ui;
    }

    public Produto create() {
        ui.header("Novo Produto");
        String nome = ui.readString("Nome: ");
        double preco = ui.readDouble("Preço: ");
        return new Produto(null, nome, preco);
    }

    public void update(Produto produto) {
        ui.header("Editar Produto: " + produto.getNome());
        String nome = ui.readString("Novo Nome (atual: " + produto.getNome() + "): ");
        double preco = ui.readDouble("Novo Preço (atual: " + produto.getPreco() + "): ");
        produto.setNome(nome);
        produto.setPreco(preco);
    }

    public void list(List<Produto> produtos) {
        ui.header("Listagem de Produtos");
        if (produtos.isEmpty()) {
            ui.display("Nenhum produto cadastrado.");
        } else {
            for (Produto p : produtos) {
                ui.display("ID: " + p.getId() + " | Nome: " + p.getNome() + " | Preço: R$ " + p.getPreco());
            }
        }
    }
}
