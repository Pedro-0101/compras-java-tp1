package View.Menu;

import Core.ConsoleUI;
import Model.Dao.PedidoDAO;
import Model.Dao.ProdutoDAO;
import Model.Entities.Pedido;
import View.Form.OrderForm;
import java.util.List;

public class OrderMenu {
    private final ConsoleUI ui;
    private final PedidoDAO pedidoDAO;
    private final OrderForm form;

    public OrderMenu(ConsoleUI ui, PedidoDAO pedidoDAO, ProdutoDAO produtoDAO) {
        this.ui = ui;
        this.pedidoDAO = pedidoDAO;
        this.form = new OrderForm(ui, produtoDAO);
    }

    public void show() {
        int option;
        do {
            ui.header("Gerenciar Pedidos");
            ui.display("1. Novo Pedido");
            ui.display("2. Listar Pedidos");
            ui.display("3. Excluir Pedido");
            ui.display("0. Voltar");
            option = ui.readInt("Opção: ");

            switch (option) {
                case 1: add(); break;
                case 2: list(); break;
                case 3: delete(); break;
                case 0: break;
                default: ui.display("Opção inválida!");
            }
        } while (option != 0);
    }

    private void add() {
        Pedido p = form.create();
        pedidoDAO.salvar(p);
        ui.display("Pedido salvo com sucesso! ID: " + p.getId());
    }

    private void list() {
        form.list(pedidoDAO.listar());
    }

    private void delete() {
        int id = ui.readInt("ID do pedido para excluir: ");
        Pedido p = findById(id);
        if (p != null) {
            pedidoDAO.remover(p);
            ui.display("Pedido removido!");
        } else {
            ui.display("Pedido não encontrado.");
        }
    }

    private Pedido findById(int id) {
        List<Pedido> lista = pedidoDAO.listar();
        for (Pedido p : lista) {
            if (p.getId().intValue() == id) return p;
        }
        return null;
    }
}
