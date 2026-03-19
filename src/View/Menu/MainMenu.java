package View.Menu;

import Core.ConsoleUI;
import Model.Dao.PedidoDAO;
import Model.Dao.ProdutoDAO;
import Model.Dao.VendaDAO;

public class MainMenu {
    private final ConsoleUI ui;
    private final ProductMenu productMenu;
    private final OrderMenu orderMenu;
    private final SaleMenu saleMenu;

    public MainMenu(ConsoleUI ui, ProdutoDAO produtoDAO, PedidoDAO pedidoDAO, VendaDAO vendaDAO) {
        this.ui = ui;
        this.productMenu = new ProductMenu(ui, produtoDAO);
        this.orderMenu = new OrderMenu(ui, pedidoDAO, produtoDAO);
        this.saleMenu = new SaleMenu(ui, vendaDAO, pedidoDAO);
    }

    public void show() {
        int option;
        do {
            ui.header("Sistema de Compras - Home");
            ui.display("1. Gerenciar Produtos");
            ui.display("2. Gerenciar Pedidos");
            ui.display("3. Gerenciar Vendas");
            ui.display("0. Sair");
            option = ui.readInt("Escolha uma opção: ");

            switch (option) {
                case 1: productMenu.show(); break;
                case 2: orderMenu.show(); break;
                case 3: saleMenu.show(); break;
                case 0: ui.display("Saindo do sistema..."); break;
                default: ui.display("Opção inválida!");
            }
        } while (option != 0);
    }
}
