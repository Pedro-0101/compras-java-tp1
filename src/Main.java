import Core.ConsoleUI;
import Core.Log.CompositeLogger;
import Core.Log.ConsoleLogger;
import Core.Log.FileLogger;
import Model.Dao.PedidoDAO;
import Model.Dao.ProdutoDAO;
import Model.Dao.VendaDAO;
import View.Menu.MainMenu;

public class Main {
    public static void main(String[] args) {
        // Initialize Logging Strategy
        CompositeLogger logger = new CompositeLogger();
        logger.addLogger(new ConsoleLogger());
        logger.addLogger(new FileLogger("session_log.txt"));

        // Initialize UI Wrapper
        ConsoleUI ui = new ConsoleUI(logger);

        // Initialize DAOs
        ProdutoDAO produtoDAO = new ProdutoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        VendaDAO vendaDAO = new VendaDAO();

        // Start Application
        MainMenu mainMenu = new MainMenu(ui, produtoDAO, pedidoDAO, vendaDAO);
        mainMenu.show();
    }
}