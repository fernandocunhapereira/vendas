package classes;

import java.util.List;
import java.util.ArrayList;

public class Comprador extends Pessoa{
	//ATRIBUTOS
	private String cpf;
	private List<Double>valoresAPagar;
	private List<Pacote>comprasRealizadas;
	
	//CONSTRUTOR
	public Comprador(String nome, double saldo, String cpf){
		super(nome, saldo);
		this.cpf=cpf;
		this.valoresAPagar=new ArrayList<>();
		this.comprasRealizadas=new ArrayList<>();
	}
	
	//GETS
	public String getCpf(){
		return this.cpf;
	}
	
	//METODOS
	@Override
	public String toString(){//toString imprime todos os dados do comprador
		String dados = "\nNome do cliente: " + this.nome;
		dados += "\nCPF: " + this.cpf;
	    dados += "\nSaldo: " + this.saldo;
	    dados += "\n\nValores a Pagar:\n";
	    for(Double valor : this.valoresAPagar){
	    	dados += valor+"\n\n";
	    }
	    dados += "\nCompras Realizadas:\n";
	    for(Pacote pacote : this.comprasRealizadas){
	    	dados += pacote+"\n\n";
	    }
	    return dados;
	}
	
	public String imprimirComprador(){ //criei esse metodo para listar apenas nome e cpf dos compradores
		String dados;
			dados ="Nome:" + this.nome + " cpf:" + this.cpf;
		return dados;
	}
	
	public void valorAPagar(double valor){
		this.valoresAPagar.add(valor);
	}
	
	public void addPacote(Pacote pacote){
		this.comprasRealizadas.add(pacote);
	}
	
	@Override
	public boolean equals(Object other){
	    if (other==null || !other.getClass().equals(Comprador.class)){
	      return false;
	    }
	    Comprador otherComprador=(Comprador) other; 
	    return otherComprador.cpf.equals(this.cpf);
	}
	
	@Override
	public int hashCode(){
	    return this.cpf.hashCode();
	}
}
