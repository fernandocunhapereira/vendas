package classes;

public class Debito extends Pagamento{
	//CONSTRUTOR
	public Debito(Comprador comprador, Vendedor vendedor, double valor){
		super(comprador, vendedor, valor);
		creditar();
		debitar();
	}
	
	//METODOS
	protected void creditar(){
		this.vendedor.saldo=+valor*0.98;
	}
}
