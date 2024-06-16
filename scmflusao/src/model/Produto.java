package model;

import java.util.ArrayList;
import java.util.List;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private double preco;
	//TODO: adicionar enum de situacao
	private String situacao;
	private Cidade cidade;
	private List<Item> itens;

	public Produto(int id, String nome, String descricao, double preco, Cidade cidade) throws ModelException {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.itens = new ArrayList<>();
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

	/**
	 * @return the situacao
	 */
	public String getSituacao() {
		return situacao;
	}

	/**
	 * @param situacao the situacao to set
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	//TODO: adicionar lancamento de exception para caso o item esteja bloqueado.
	public void adicionarItem(Item item) {
        if (!itens.contains(item)) {
            this.itens.add(item);
        }
    }

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) throws ModelException {
		if (cidade == null) {
			throw new ModelException("O produto deve pertencer a uma cidade.");
		}
		this.cidade = cidade;
		cidade.adicionarProduto(this); 
	}

}
