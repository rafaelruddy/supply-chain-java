package model;

import java.util.ArrayList;
import java.util.List;

import model.Agente.StatusEmpresaParceira;

public class EmpresaParceira {
	private int id;
	private String nome;
	private String cnpj;
	private StatusEmpresaParceira situacao;
	private List<Agente> agentes;

	public EmpresaParceira(int id, String nome, String cnpj) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.agentes = new ArrayList<>();
		this.setSituacao(StatusEmpresaParceira.ATIVO);
	}

	public static enum StatusEmpresaParceira {
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

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public StatusEmpresaParceira getSituacao() {
		return situacao;
	}

	public void setSituacao(StatusEmpresaParceira situacao) {
		this.situacao = situacao;
	}

	public void adicionarAgente(Agente agente) throws ModelException {
		if (agente == null) {
			throw new ModelException("O agente não pode ser nulo.");
		}

		if (agente.getSituacao() != Agente.StatusAgente.ATIVO) {
			throw new ModelException("O agente deve ter o status ativo.");
		}

		if (!agentes.contains(agente)) {
			this.agentes.add(agente);
		}
	}
}
