package View.Form;

import Core.ConsoleUI;
import Model.Dao.ProdutoDAO;
import Model.Entities.ItemPedido;
import Model.Entities.Pedido;
import Model.Entities.Produto;
import java.util.Date;
import java.util.List;

public class OrderForm {
    private final ConsoleUI ui;
    private final ProdutoDAO produtoDAO;

    public OrderForm(ConsoleUI ui, ProdutoDAO produtoDAO) {
        this.ui = ui;
        this.produtoDAO = produtoDAO;
    }

    public Pedido create() {
        ui.header("Novo Pedido");
        Pedido pedido = new Pedido(null, new Date(), 0.0);
        
        boolean addMore = true;
        while (addMore) {
            Produto p = selectProduct();
            if (p != null) {
                int qtd = ui.readInt("Quantidade: ");
                pedido.adicionarItem(new ItemPedido(qtd, p));
                ui.display("Item adicionado: " + p.getNome() + " (x" + qtd + ")");
            }
            String resp = ui.readString("Deseja adicionar outro item? (S/N): ");
            addMore = resp.equalsIgnoreCase("S");
        }
        
        ui.display("Subtotal do pedido: R$ " + pedido.getValorTotal());
        return pedido;
    }

    private Produto selectProduct() {
        List<Produto> produtos = produtoDAO.lista();
        if (produtos.isEmpty()) {
            ui.display("Nenhum produto cadastrado para selecionar.");
            return null;
        }
        
        ui.display("Produtos disponíveis:");
        for (Produto p : produtos) {
            ui.display(p.getId() + ". " + p.getNome() + " (R$ " + p.getPreco() + ")");
        }
        
        int id = ui.readInt("ID do Produto: ");
        for (Produto p : produtos) {
            if (p.getId().intValue() == id) return p;
        }
        ui.display("Produto não encontrado.");
        return null;
    }

    public void list(List<Pedido> pedidos) {
        ui.header("Listagem de Pedidos");
        if (pedidos.isEmpty()) {
            ui.display("Nenhum pedido cadastrado.");
        } else {
            for (Pedido p : pedidos) {
                ui.display("ID: " + p.getId() + " | Data: " + p.getData() + " | Total: R$ " + p.getValorTotal());
            }
        }
    }
}
