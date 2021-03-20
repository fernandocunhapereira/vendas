package classes;

public class Pix extends Pagamento{
	//CONSTRUTOR
	public Pix(Comprador comprador, Vendedor vendedor, double valor){
		super(comprador, vendedor, valor);
		creditar();
		debitar();
	}
}
