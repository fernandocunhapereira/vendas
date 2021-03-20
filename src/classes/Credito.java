package classes;

public class Credito extends Pagamento{
	//CONSTRUTOR
	public Credito(Comprador comprador, Vendedor vendedor, double valor){
		super(comprador, vendedor, valor);
		creditar();
		debitar();
	}
	
	//METODOS
	protected void creditar(){
		this.vendedor.valorAReceber(valor*0.96);
	}
	
	protected void debitar(){
		this.comprador.valorAPagar(valor);
	}
}
