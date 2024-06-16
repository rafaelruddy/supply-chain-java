package model;

import java.util.ArrayList;
import java.util.List;

public class Cidade {
	private int id;
	private String nome;
	private String estado;
	private Pais pais;
	//TODO: adicionar enum de situacao
	private String situacao;
	private List<Armazem> armazens;
	private List<Produto> produtos;

	public Cidade(int id, String nome, String estado, Pais pais) throws ModelException {
		this.id = id;
		this.nome = nome;
		this.estado = estado;
		this.armazens = new ArrayList<>();
		this.produtos = new ArrayList<>();
		this.setPais(pais);
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Armazem> getArmazens() {
		return armazens;
	}

	// Método para adicionar um armazém
	public void adicionarArmazem(Armazem armazem) {
		if (!armazens.contains(armazem)) {
			this.armazens.add(armazem);
		}
	}
	
	// Método para adicionar um armazém
	public void adicionarProduto(Produto produto) {
		if (!produtos.contains(produto)) {
			this.produtos.add(produto);
		}
	}

	public Pais getPais() {
		return pais;
	}

	//TODO: adicionar lancamento de exception para caso o pais esteja bloqueado.
	public void setPais(Pais pais) throws ModelException {
		if (pais == null) {
			throw new ModelException("A cidade deve pertencer a um país.");
		}
		this.pais = pais;
		pais.adicionarCidade(this);
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
