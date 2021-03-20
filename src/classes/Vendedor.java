package classes;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Vendedor extends Pessoa{
	//ATRIBUTOS
	private String cnpj;
	private List<Double>valoresAReceber;
	private List<Pacote>vendasRealizadas;
	private Set<Produto>catalogoProdutos;
	Scanner input=new Scanner(System.in);
	
	//CONSTRUTOR
	public Vendedor(String nome, double saldo, String cnpj){
		super(nome, saldo);
		this.cnpj=cnpj;
		this.valoresAReceber=new ArrayList<>();
		this.vendasRealizadas=new ArrayList<>();
		this.catalogoProdutos=new HashSet<>();
	}
	
	//GETS
	public String getCnpj(){
		return this.cnpj;
	}
	
	//METODOS
	@Override
	public String toString(){//toString imprime todos os dados do vendedor
		String dados = "\nNome do vendedor: " + this.nome;
		dados += "\nCNPJ: " + this.cnpj;
	    dados += "\nSaldo: " + this.saldo;
	    dados += "\n\nValores a Receber:\n";
	    for(Double valor : this.valoresAReceber){
	    	dados += valor+"\n\n";
	    }
	    dados += "\nVendas Realizadas:\n";
	    for(Pacote pacote : this.vendasRealizadas){
	    	dados += pacote+"\n\n";
	    }
	    dados += "\nCATÁLOGO DE PRODUTOS:\n";
	    for(Produto produto : this.catalogoProdutos){
	    	dados += produto+"\n\n";
	    }
	    return dados;
	}
	
	public String imprimirVendedor(){//criei esse metodo para listar apenas nome e cnpj dos vendedores
		String dados;
			dados ="Nome:" + this.nome + " cnpj:" + this.cnpj;
		return dados;
	}
	
	public void imprimirCatalogo(){
		for(Produto produto : this.catalogoProdutos){
			System.out.println(produto);
			System.out.println("");
		}
	}
	
	public void addPacote(Pacote pacote){
		this.vendasRealizadas.add(pacote);
	}
	
	public void addNoCatalogo(){
		boolean achou=false;
		String codigo;
		do{
			System.out.println("Digite o codigo do produto:");
			codigo=input.next();
			if(!this.catalogoProdutos.isEmpty()){
				for(Produto produto : this.catalogoProdutos){
					if(produto.getCodigo().equals(codigo)){
						System.out.println("Já existe produto cadastrado com esse código !!!");
						achou=true;
					}else{
						achou=false;
					}
				}
			}
		}while(achou);
		System.out.println("Digite o nome do produto:");
		String nome=input.next();
		System.out.println("Digite o valor do produto:");
		double valor=input.nextDouble();
		Produto novoProduto=new Produto(codigo, nome, valor);
		this.catalogoProdutos.add(novoProduto);
	}
	
	public Produto getProduto(String codigo){	
		Produto nulo=null;
		Produto achado=new Produto("x","y",0);
		boolean achou=false;
		for(Produto produto : this.catalogoProdutos){
			if(produto.getCodigo().equals(codigo)){
				achado=produto;
				achou=true;
			}
		}
		if(achou){
			return achado;
		}else{
			System.out.println("Produto nao encontrado no catálogo !!!");
			return nulo;
		}
	}

	public void valorAReceber(double valor){
		this.valoresAReceber.add(valor);
	}
	
	@Override
	public boolean equals(Object other){
	    if (other==null || !other.getClass().equals(Vendedor.class)){
	      return false;
	    }
	    Vendedor otherVendedor=(Vendedor) other; 
	    return otherVendedor.cnpj.equals(this.cnpj);
	}
	@Override
	public int hashCode(){
	    return this.cnpj.hashCode();
	}

}
