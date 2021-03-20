package classes;

import java.util.Scanner;

public class Menu{
	//ATRIBUTOS
	CadastroVendedor vendedores;
	CadastroComprador compradores;
	
	//CONSTRUTOR
	public Menu(CadastroVendedor vendedores, CadastroComprador compradores){
		this.vendedores=vendedores;
		this.compradores=compradores;
	}
	
	Scanner input=new Scanner(System.in);
	public void principal(){
		int opcao=100;
		do{
			System.out.println("\n##################");
			System.out.println("# MENU PRINCIPAL #");
			System.out.println("##################");
			System.out.println("1-Cadastrar comprador");
			System.out.println("2-Cadastrar vendedor");
			System.out.println("3-Cadastrar produto");
			System.out.println("4-Imprimir dados de comprador");
			System.out.println("5-Imprimir dados de vendedor");
			System.out.println("6-Cadastrar uma compra/venda");
			System.out.println("0-SAIR");
			System.out.println("Digite o numero da opção:");
			opcao=input.nextInt();
			switch(opcao){
			case 0:
				System.out.println("");
				System.out.println("SESSÃO ENCERRADA");
				break;
			case 1:
				cadastrarComprador();
				break;
			case 2:
				cadastrarVendedor();
				break;	
			case 3:
				cadastrarProduto();
				break;
			case 4:
				imprimirComprador();
				break;
			case 5:
				imprimirVendedor();
				break;
			case 6:
				cadastrarCompraVenda();
				break;
			default:
				System.out.println("\nOpção inválida !!!");
				break;
			}
		}while(opcao!=0);
	}//fim metodo principal
	
	public void cadastrarComprador(){
		System.out.println("");
		System.out.println("CADASTRAR COMPRADOR");
		this.compradores.addComprador();
	}
	
	public void cadastrarVendedor(){
		System.out.println("");
		System.out.println("CADASTRAR VENDEDOR");
		this.vendedores.addVendedor();
	}
	
	public void cadastrarProduto(){
		String cnpj;
		System.out.println("");
		System.out.println("CADASTRAR PRODUTO");
		System.out.println("Digite o cnpj do vendedor:");
		cnpj=input.next();
		if(this.vendedores.getVendedor(cnpj)!=null){
			this.vendedores.getVendedor(cnpj).addNoCatalogo();
		}else{
			int opc;
			System.out.println("Digite 1 para listar os vendedores ou outro numero para sair:");
			opc=input.nextInt();
			if(opc==1){
				System.out.println("\nVENDEDORES CADASTRADOS");
				this.vendedores.imprimirVendedores();
			}
		}
		
	}
	
	public void imprimirComprador(){
		String cpf;
		System.out.println("");
		System.out.println("IMPRIMIR DADOS DE COMPRADOR");
		System.out.println("Digite o cpf do comprador:");
		cpf=input.next();
		if(this.compradores.getComprador(cpf)!=null){
			System.out.println(this.compradores.getComprador(cpf));
		}else{
			int opc;
			System.out.println("Digite 1 para listar os compradores ou outro numero para sair:");
			opc=input.nextInt();
			if(opc==1){
				System.out.println("\nCOMPRADORES CADASTRADOS");
				this.compradores.imprimirCompradores();
			}
		}
		
	}
	
	public void imprimirVendedor(){
		String cnpj;
		System.out.println("");
		System.out.println("IMPRIMIR DADOS DE VENDEDOR");
		System.out.println("Digite o cnpj do vendedor:");
		cnpj=input.next();
		if(this.vendedores.getVendedor(cnpj)!=null){
			System.out.println(this.vendedores.getVendedor(cnpj));
		}else{
			int opc;
			System.out.println("Digite 1 para listar os vendedores ou outro numero para sair:");
			opc=input.nextInt();
			if(opc==1){
				System.out.println("\nVENDEDORES CADASTRADOS");
				this.vendedores.imprimirVendedores();
			}
		}	
	}
	
	public void cadastrarCompraVenda(){
		System.out.println("");
		System.out.println("CADASTRAR UMA COMPRA/VENDA");
		Transacao transacao=new Transacao(compradores, vendedores);
	}
	
}//fim classe Menu
