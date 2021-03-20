package classes;

public class Pessoa{
	//ATRIBUTOS
	protected String nome;
	protected double saldo;
	
	//CONSTRUTOR
	public Pessoa(String nome, double saldo){
		this.nome=nome;
		this.saldo=saldo;
	}
	
	//GETS
	protected double getSaldo(){
		return this.saldo;
	}
	
	//SETS
	/*protected void setNome(String nome){
		this.nome=nome;
	}*/
	
	/*protected void setSaldo(double saldo){
		this.saldo=saldo;
	}*/
	
}
