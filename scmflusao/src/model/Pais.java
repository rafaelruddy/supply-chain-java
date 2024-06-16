package model;

import java.util.ArrayList;
import java.util.List;

public class Pais {
	private int id;
	private String nome;
	private String sigla;
	//TODO: adicionar enum de situacao
	private String situacao;
	private List<Cidade> cidades;

	public Pais(int id, String nome, String sigla)
	{
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.cidades = new ArrayList<>();
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
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * @param sigla the sigla to set
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public List<Cidade> getCidades() {
        return cidades;
    }
	
	//TODO: adicionar lancamento de exception para caso a cidade esteja bloqueada.
	public void adicionarCidade(Cidade cidade) {
        if (!cidades.contains(cidade)) {
            this.cidades.add(cidade);
        }
    }

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
