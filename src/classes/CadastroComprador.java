package classes;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class CadastroComprador{
	public Set<Comprador> compradores;
	Scanner input=new Scanner(System.in);
	
	//CONSTRUTOR
	public CadastroComprador(){
		this.compradores=new HashSet<>();
	}
	
	//GETS
	public Comprador getComprador(String cpf){
		Comprador nulo=null;
		Comprador achado=new Comprador("X",0,"Y");
		boolean achou=false;
		for(Comprador comprador : compradores){
			if(comprador.getCpf().equals(cpf)){
				achado=comprador;
				achou=true;
			}
		}
		if(achou){
			return achado;
		}else{
			System.out.println("Comprador não encontrado !!!");
			return nulo;
		}
		
	}
	
	//METODOS
	public void addComprador(){
		String nome;
		String cpf;
		double saldo;
		boolean achou=false;
		System.out.println("Digite o nome do comprador:");
		nome=input.next();
		do{
			System.out.println("Digite o cpf do comprador:");
			cpf=input.next();
			if(!this.compradores.isEmpty()){
				for(Comprador comprador : this.compradores){
					if(comprador.getCpf().equals(cpf)){
						System.out.println("Este cpf já está cadastrado !!!");
						achou=true;
					}else{
						achou=false;
					}
				}
			}
		}while(achou);
		System.out.println("Digite o saldo do comprador:");
		saldo=input.nextDouble();
		Comprador comprador=new Comprador(nome,saldo,cpf);
		this.compradores.add(comprador);
	}
	
	@Override
	public String toString(){
		String dados="";
	    for(Comprador comprador:compradores){
	    	dados += comprador+"\n\n";
	    }
	    return dados;
	}
	
	public void imprimirCompradores(){
	    for(Comprador comprador:compradores){
	    	System.out.println(comprador.imprimirComprador());
	    }
	}
}
