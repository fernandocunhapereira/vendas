package classes;

public class Pacote {
	//ATRIBUTOS
	private int quantidade;
	private Produto produto;
	private double totalPacote;
	
	//CONSTRUTOR
	public Pacote(int qtd, Produto prod){
		this.quantidade=qtd;
		this.produto=prod;
		this.totalPacote=qtd*prod.getPrecoUnitario();
	}
	
	//GET
	public double getTotalPacote(){
		return this.totalPacote;
	}
	
	//METODOS
	@Override
	public String toString(){
		String strPacote = "Produto\t\t Quantidade\t\t Preço pacote"; 
		strPacote += "\n" + this.produto.getNome()
		+"\t\t " + this.quantidade
	    +"\t\t " + this.totalPacote;
	    return strPacote;
	}
}
