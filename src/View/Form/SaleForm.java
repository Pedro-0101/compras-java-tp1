package View.Form;

import Core.ConsoleUI;
import Model.Dao.PedidoDAO;
import Model.Entities.Pedido;
import Model.Entities.Venda;
import java.util.List;

public class SaleForm {
    private final ConsoleUI ui;
    private final PedidoDAO pedidoDAO;

    public SaleForm(ConsoleUI ui, PedidoDAO pedidoDAO) {
        this.ui = ui;
        this.pedidoDAO = pedidoDAO;
    }

    public Venda create() {
        ui.header("Nova Venda");
        Pedido pedido = selectPedido();
        if (pedido != null) {
            return new Venda(pedido);
        }
        return null;
    }

    private Pedido selectPedido() {
        List<Pedido> pedidos = pedidoDAO.listar();
        if (pedidos.isEmpty()) {
            ui.display("Nenhum pedido cadastrado para realizar venda.");
            return null;
        }

        ui.display("Pedidos disponíveis (não faturados):");
        for (Pedido p : pedidos) {
            ui.display(p.getId() + ". Pedido ID: " + p.getId() + " - Valor: R$ " + p.getValorTotal());
        }

        int id = ui.readInt("Selecione o ID do Pedido: ");
        for (Pedido p : pedidos) {
            if (p.getId().intValue() == id) return p;
        }
        ui.display("Pedido não encontrado.");
        return null;
    }

    public void list(List<Venda> vendas) {
        ui.header("Listagem de Vendas");
        if (vendas.isEmpty()) {
            ui.display("Nenhuma venda realizada.");
        } else {
            for (Venda v : vendas) {
                ui.display("ID Venda: " + v.getId() + " | Pedido ID: " + v.getPedido().getId() + " | Data: " + v.getData() + " | Total: R$ " + v.getValorTotal());
            }
        }
    }
}
