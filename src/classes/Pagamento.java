package classes;

public class Pagamento {
	//ATRIBUTOS
	protected Comprador comprador;
	protected Vendedor vendedor;
	protected double valor;
	
	//CONSTRUTOR
	protected Pagamento(Comprador comprador, Vendedor vendedor, double valor){
		this.comprador=comprador;
		this.vendedor=vendedor;
		this.valor=valor;
	}
	
	//METODOS
	protected void creditar(){
		this.vendedor.saldo+=valor;
	}
	
	protected void debitar(){
		this.comprador.saldo-=valor;
	}
}
