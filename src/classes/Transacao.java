package classes;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.time.LocalDate;

public class Transacao{
	//ATRIBUTOS
	CadastroComprador compradores;
	CadastroVendedor vendedores;
	private String cpfComprador;
	private String cnpjVendedor;
	private int formaPagamento;
	private Set<Pacote> carrinho;
	private double totalTransacao=0;
	Scanner input=new Scanner(System.in);
	
	//CONSTRUTOR
	public Transacao(CadastroComprador compradores, CadastroVendedor vendedores){
		this.carrinho=new HashSet<>();
		this.compradores=compradores;
		this.vendedores=vendedores;
		int opcao;
		boolean encontrou=false;
		do{
			System.out.println("\nDigite o cpf do comprador:");
			this.cpfComprador=input.next();
			if(this.compradores.getComprador(cpfComprador)!=null){
				encontrou=true;
			}
			if(this.compradores.getComprador(cpfComprador)==null){
				int opc;
				System.out.println("Digite 1 para listar os compradores ou outro numero para tentar novamente:");
				opc=input.nextInt();
				if(opc==1){
					System.out.println("\nCOMPRADORES CADASTRADOS");
					this.compradores.imprimirCompradores();
				}
			}
		}while(encontrou==false);
		encontrou=false;
		do{
			System.out.println("\nDigite o cnpj do vendedor:");
			this.cnpjVendedor=input.next();
			if(this.vendedores.getVendedor(cnpjVendedor)!=null){
				encontrou=true;
			}
			if(this.vendedores.getVendedor(cnpjVendedor)==null){
				int opc;
				System.out.println("Digite 1 para listar os vendedores ou outro numero para tentar novamente:");
				opc=input.nextInt();
				if(opc==1){
					System.out.println("\nVENDEDORES CADASTRADOS");
					this.vendedores.imprimirVendedores();
				}
			}
		}while(encontrou==false);
		do{
			System.out.println("\n###################");
			System.out.println("# MENU DE COMPRAS #");
			System.out.println("###################");
			System.out.println("1-Adicionar produto ao carrinho");
			System.out.println("2-Imprimir catálogo do vendedor");
			System.out.println("3-Mostrar itens do carrinho");
			System.out.println("4-Ir para forma de pagamento");
			System.out.println("Digite o numero opção:");
			opcao=input.nextInt();
			switch(opcao){
			case 1:
				adicionaPacote();
				break;
			case 2:
				System.out.println("\nCATÁLOGO DE PRODUTOS");
				this.vendedores.getVendedor(cnpjVendedor).imprimirCatalogo();
				break;
			case 3:
				if(this.carrinho.isEmpty()){
					System.out.println("\nCarrinho vazio !!!");
				}else{
					System.out.println("\nCARRINHO");
					for(Pacote pacote : this.carrinho){
						System.out.println(pacote);
					}
				}
			case 4:
				break;
			default:
				System.out.println("Opção inválida !!!");
				break;
			}
		}while(opcao!=4);
		do{
			System.out.println("\nDigite a forma de pagamento");
			System.out.println("1-PIX | 2-Boleto | 3-Debito | 4-Credito");
			this.formaPagamento=input.nextInt();
			switch(this.formaPagamento){
				case 1:
					System.out.println("\nPIX");
					Pix x=new Pix(this.compradores.getComprador(cpfComprador), this.vendedores.getVendedor(cnpjVendedor), totalTransacao);
					break;
				case 2:
					System.out.println("\nBOLETO");
					System.out.println("Digite o ano do vencimento YYYY");
					int ano=input.nextInt();
					System.out.println("Digite o mes do vencimento MM");
					int mes=input.nextInt();
					System.out.println("Digite o dia do vencimento DD");
					int dia=input.nextInt();
					Boleto y=new Boleto(this.compradores.getComprador(cpfComprador), this.vendedores.getVendedor(cnpjVendedor), totalTransacao, ano, mes, dia);
					if(y.vencimento.isBefore(LocalDate.now())){
						System.out.println("ATENÇÃO: Boleto vencido !!!");
					}
					break;
				case 3:
					System.out.println("\nDEBITO");
					Debito z=new Debito(this.compradores.getComprador(cpfComprador), this.vendedores.getVendedor(cnpjVendedor), totalTransacao);
					break;
				case 4:
					Credito w=new Credito(this.compradores.getComprador(cpfComprador), this.vendedores.getVendedor(cnpjVendedor), totalTransacao);
					System.out.println("\nCREDITO");
					break;
				default:
					System.out.println("\nOpção inválida !!!");
					break;
			}
		}while(this.formaPagamento<1 || this.formaPagamento>4);
	}
	
	//METODOS
	public void adicionaPacote(){
		String codigo;
		boolean achou=false;
		do {
			System.out.println("\nDigite o codigo do produto");
			codigo=input.next();
			if(this.vendedores.getVendedor(cnpjVendedor).getProduto(codigo)==null){
				System.out.println("Digite 1 para imprimir catálogo do vendedor, ou outro numero para tentar novamente:");
				int opcao=input.nextInt();
				if(opcao==1){
					this.vendedores.getVendedor(cnpjVendedor).imprimirCatalogo();
				}
			}else{
				achou=true;
			}
		}while(!achou);
		System.out.println("Digite a quantidade:");
		int quantidade=input.nextInt();
		Pacote pacote=new Pacote(quantidade, this.vendedores.getVendedor(cnpjVendedor).getProduto(codigo));//BUGADO ESSA LINHA
		this.totalTransacao+=pacote.getTotalPacote();
		this.carrinho.add(pacote);
		this.vendedores.getVendedor(cnpjVendedor).addPacote(pacote);
		this.compradores.getComprador(cpfComprador).addPacote(pacote);
	}
}
