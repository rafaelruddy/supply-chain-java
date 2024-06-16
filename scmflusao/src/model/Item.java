package model;


public class Item {
	private int id;
	private String nome;
	private String descricao;
	private double preco;
	private StatusItem situacao;
	
	public Item(int id, String nome, String descricao, double preco) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.setSituacao(StatusItem.EM_ANÁLISE);
	}
	
	public static enum StatusItem {
		EM_ANÁLISE,
		REPROVADO,
		ATIVO,
		BLOQUEADO
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}
	/**
	 * @param preco the preco to set
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public StatusItem getSituacao() {
		return situacao;
	}
	public void setSituacao(StatusItem situacao) {
		this.situacao = situacao;
	}
}
