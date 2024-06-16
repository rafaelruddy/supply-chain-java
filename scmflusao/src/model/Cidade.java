package model;

import java.util.ArrayList;
import java.util.List;

import model.Agente.StatusCidade;

public class Cidade {
	private int id;
	private String nome;
	private String estado;
	private Pais pais;
	private StatusCidade situacao;
	private List<Armazem> armazens;
	private List<Produto> produtos;

	public Cidade(int id, String nome, String estado, Pais pais) throws ModelException {
		this.id = id;
		this.nome = nome;
		this.estado = estado;
		this.armazens = new ArrayList<>();
		this.produtos = new ArrayList<>();
		this.setPais(pais);
		this.setSituacao(StatusCidade.ATIVO);
	}

	public static enum StatusCidade {
		ATIVO, BLOQUEADO
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
	public void adicionarArmazem(Armazem armazem) throws ModelException {
		if (armazem == null) {
			throw new ModelException("O armazem não pode ser nulo.");
		}

		if (armazem.getSituacao() != Armazem.StatusArmazem.ATIVO) {
			throw new ModelException("O armazem deve ter o status ativo.");
		}

		if (this.getSituacao() != Cidade.StatusCidade.ATIVO
				&& this.getPais().getSituacao() != Pais.StatusPais.ATIVO) {
			throw new ModelException("A cidade e o país devem ter o status ativo.");
		}

		if (!armazens.contains(armazem)) {
			this.armazens.add(armazem);
		}
	}

	// Método para adicionar um armazém
	public void adicionarProduto(Produto produto) throws ModelException {
		if (produto == null) {
			throw new ModelException("O produto não pode ser nulo.");
		}

		if (produto.getSituacao() != Produto.StatusProduto.ATIVO) {
			throw new ModelException("O produto deve ter o status ativo.");
		}

		if (!produtos.contains(produto)) {
			this.produtos.add(produto);
		}
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) throws ModelException {
		if (pais == null) {
			throw new ModelException("O país não pode ser nulo.");
		}

		if (pais.getSituacao() != Pais.StatusPais.ATIVO) {
			throw new ModelException("O país deve ter o status ativo.");
		}

		this.pais = pais;
		pais.adicionarCidade(this);
	}

	public StatusCidade getSituacao() {
		return situacao;
	}

	public void setSituacao(StatusCidade situacao) {
		this.situacao = situacao;
	}

}
