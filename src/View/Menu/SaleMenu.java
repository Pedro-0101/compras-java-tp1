package View.Menu;

import Core.ConsoleUI;
import Model.Dao.PedidoDAO;
import Model.Dao.VendaDAO;
import Model.Entities.Venda;
import View.Form.SaleForm;
import java.util.List;

public class SaleMenu {
    private final ConsoleUI ui;
    private final VendaDAO vendaDAO;
    private final SaleForm form;

    public SaleMenu(ConsoleUI ui, VendaDAO vendaDAO, PedidoDAO pedidoDAO) {
        this.ui = ui;
        this.vendaDAO = vendaDAO;
        this.form = new SaleForm(ui, pedidoDAO);
    }

    public void show() {
        int option;
        do {
            ui.header("Gerenciar Vendas");
            ui.display("1. Realizar Venda");
            ui.display("2. Listar Vendas");
            ui.display("3. Estornar Venda");
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
        Venda v = form.create();
        if (v != null) {
            vendaDAO.salvar(v);
            ui.display("Venda realizada com sucesso! ID: " + v.getId());
        }
    }

    private void list() {
        form.list(vendaDAO.listar());
    }

    private void delete() {
        int id = ui.readInt("ID da venda para estornar: ");
        Venda v = findById(id);
        if (v != null) {
            vendaDAO.remover(v);
            ui.display("Venda estornada!");
        } else {
            ui.display("Venda não encontrada.");
        }
    }

    private Venda findById(int id) {
        List<Venda> lista = vendaDAO.listar();
        for (Venda v : lista) {
            if (v.getId().intValue() == id) return v;
        }
        return null;
    }
}
