package classes;

import java.time.LocalDate;

public class Boleto extends Pagamento{
	//ATRIBUTOS
	LocalDate vencimento=LocalDate.now();
	
	//CONSTRUTOR
	public Boleto(Comprador comprador, Vendedor vendedor, double valor, int ano, int mes, int dia){
		super(comprador, vendedor, valor);
		this.vencimento=vencimento.withYear(ano);
		this.vencimento=vencimento.withMonth(mes);
		this.vencimento=vencimento.withDayOfMonth(dia);
		creditar();
		debitar();
	}
	
	//METODOS
	protected void creditar(){
		this.vendedor.valorAReceber(valor-5);
	}
}