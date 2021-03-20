import classes.CadastroComprador;
import classes.CadastroVendedor;
import classes.Menu;

public class Programa{

	public static void main(String[] args){
		System.out.println("teste Para Compilar");
		
		CadastroComprador listaCompradores=new CadastroComprador();
		CadastroVendedor listaVendedores=new CadastroVendedor();		
		Menu menu=new Menu(listaVendedores, listaCompradores);
		menu.principal();
		
	}//fim da MAIN
}//fim classe PROGRAMA