package model;

public class Armazem {
	private int id;
	private String nome;
	private String endereco;
	private Cidade cidade;
	//TODO: adicionar enum de situacao
	private String situacao;
	

	public Armazem(int id, String nome, String endereco, Cidade cidade) throws ModelException{
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.setCidade(cidade);
		this.setSituacao("Ativo");
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
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Cidade getCidade() {
		return cidade;
	}

	//TODO: adicionar lancamento de exception para caso a cidade esteja bloqueada.
	private void setCidade(Cidade cidade) throws ModelException{
		if (cidade == null) {
			throw new ModelException("O armazém deve pertencer a uma cidade.");
		}
		this.cidade = cidade;
		cidade.adicionarArmazem(this); 
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
