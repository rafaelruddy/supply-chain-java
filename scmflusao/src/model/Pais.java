package model;

import java.util.ArrayList;
import java.util.List;

import model.Agente.StatusPais;

public class Pais {
	private int id;
	private String nome;
	private String sigla;
	private StatusPais situacao;
	private List<Cidade> cidades;

	public Pais(int id, String nome, String sigla)
	{
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.cidades = new ArrayList<>();
		this.setSituacao(StatusPais.ATIVO);
	}
	
	public static enum StatusPais {
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
	
	public void adicionarCidade(Cidade cidade) throws ModelException {
		if (cidade == null) {
			throw new ModelException("A cidade não pode ser nula.");
		}  
		
		if (cidade.getSituacao() != Cidade.StatusCidade.ATIVO) {
			throw new ModelException("A cidade deve ter o status ativo.");
		}
		
        if (!cidades.contains(cidade)) {
            this.cidades.add(cidade);
        }
    }

	public StatusPais getSituacao() {
		return situacao;
	}

	public void setSituacao(StatusPais situacao) {
		this.situacao = situacao;
	}
}
