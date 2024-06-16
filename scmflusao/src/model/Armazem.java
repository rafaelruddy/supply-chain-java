package model;

public class Armazem {
	private int id;
	private String nome;
	private String endereco;
	private Cidade cidade;
	private StatusArmazem situacao;
	

	public Armazem(int id, String nome, String endereco, Cidade cidade) throws ModelException{
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.setCidade(cidade);
		this.setSituacao(StatusArmazem.ATIVO);
	}
	
	public static enum StatusArmazem {
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

	public StatusArmazem getSituacao() {
		return situacao;
	}
	
	

	public void setSituacao(StatusArmazem situacao) {
		this.situacao = situacao;
	}

}
