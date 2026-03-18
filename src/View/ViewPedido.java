package View;

import Model.Dao.PedidoDao;
import View.Forms.FormPedido;
import View.auxiliar.LerOpcao;

public class ViewPedido {
    
    PedidoDao pedidoDao = new PedidoDao();
    FormPedido formPedido = new FormPedido();

    public static void main(String[] args) {

		PedidoDao pedidoDao = new PedidoDao();
		LerOpcao lerOpcao = new LerOpcao();
        FormPedido formPedido = new FormPedido();
		

		int valorLido = 0;
		while ((valorLido = lerOpcao.mostrarMenueLer()) != 6) {

			switch (valorLido) {
			case 1:
                Integer id = pedidoDao.getContadorSequencial();
                formPedido.processaInclusao(id);
            break;
            }
        }
    }
}
