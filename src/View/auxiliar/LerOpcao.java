package View.auxiliar;

import java.util.Scanner;

public class LerOpcao {
	Scanner leitor=new Scanner(System.in);
	
	public int mostrarMenueLer() {
		System.out.println("=========================================");
		System.out.println("===========ESCOLHA UMA OPÇÂO=============");
		System.out.println("==[1]-INCLUIR   [2]-EXCLUIR [3]-BUSCAR ==\n"
				         + "==[4]-ATUALIZAR [5]-LISTAR  [6]-VOLTAR ==");
		int valor=leitor.nextInt();
		
		return valor;
	}
}
