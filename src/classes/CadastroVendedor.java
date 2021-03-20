package classes;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class CadastroVendedor {
	public Set<Vendedor> vendedores;
	Scanner input=new Scanner(System.in);
	
	//CONSTRUTOR
	public CadastroVendedor(){
		this.vendedores=new HashSet<>();
	}
	
	//GETS
	public Vendedor getVendedor(String cnpj){
		Vendedor nulo=null;
		Vendedor achado=new Vendedor("X",0,"Y");
		boolean achou=false;
		for(Vendedor vendedor : vendedores){
			if(vendedor.getCnpj().equals(cnpj)){
				achado=vendedor;
				achou=true;
			}
		}
		if(achou){
			return achado;
		}else{
			System.out.println("Vendedor não encontrado !!!");
			return nulo;
		}
	}
	
	//METODOS
	public void addVendedor(){
		String nome;
		String cnpj;
		double saldo;
		boolean achou=false;
		System.out.println("Digite o nome do vendedor:");
		nome=input.next();
		do{
			System.out.println("Digite o cnpj do vendedor:");
			cnpj=input.next();
			if(!this.vendedores.isEmpty()){
				for(Vendedor vendedor : this.vendedores){
					if(vendedor.getCnpj().equals(cnpj)){
						System.out.println("Este cnpj já está cadastrado !!!");
						achou=true;
					}else{
						achou=false;
					}
				}
			}
		}while(achou);
		System.out.println("Digite o saldo do vendedor:");
		saldo=input.nextDouble();
		Vendedor vendedor=new Vendedor(nome,saldo,cnpj);
		this.vendedores.add(vendedor);
	}
	
	@Override
	public String toString(){
		String dados="";
	    for(Vendedor vendedor : vendedores){
	    	dados += vendedor+"\n\n";
	    }
	    return dados;
	}
	
	public void imprimirVendedores(){
	    for(Vendedor vendedor : vendedores){
	    	System.out.println(vendedor.imprimirVendedor());
	    }
	}
	
}
