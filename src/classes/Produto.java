package classes;

public class Produto{
	//ATRIBUTOS
	private String codigo;
	private String nome;
	private double precoUnitario;
	
	//CONSTRUTOR
	public Produto(String codigo, String nome, double precoUnitario){
		this.codigo=codigo;
		this.nome=nome;
		this.precoUnitario=precoUnitario;
	}
	
	//GETS
	public double getPrecoUnitario(){
		return this.precoUnitario;
	}
	public String getNome(){
		return this.nome;
	}
	public String getCodigo(){
		return this.codigo;
	}
	
	//SETS
	public void setCodigo(String codigo){
		this.codigo=codigo;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	public void setPrecoUnitario(double precoUnitario){
		this.precoUnitario=precoUnitario;
	}
	
	//METODOS
	@Override
	public String toString(){
		String dados = "Codigo do produto: " + this.codigo;
		dados += "\nNome: " + this.nome;
	    dados += "\nPreco unitario: " + this.precoUnitario;
	    return dados;
	}
	
	@Override
	public boolean equals(Object other){
	    if (other==null || !other.getClass().equals(Produto.class)){
	      return false;
	    }
	    Produto otherProduto=(Produto) other; 
	    return otherProduto.codigo.equals(this.codigo);
	}
	@Override
	public int hashCode(){
	    return this.codigo.hashCode();
	}
}
