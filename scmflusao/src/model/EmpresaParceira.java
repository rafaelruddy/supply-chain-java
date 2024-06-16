package model;

import java.util.ArrayList;
import java.util.List;

public class EmpresaParceira {
	private int id;
	private String nome;
	private String cnpj;
	//TODO: adicionar enum de situacao
	private String situacao;
	private List<Agente> agentes;
	
	public EmpresaParceira(int id, String nome, String cnpj) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.agentes = new ArrayList<>();
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
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	//TODO: adicionar lancamento de exception para caso o agente esteja bloqueado.
	public void adicionarAgente(Agente agente) {
        if (!agentes.contains(agente)) {
            this.agentes.add(agente);
        }
    }
}
