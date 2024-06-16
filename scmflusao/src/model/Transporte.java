package model;

public class Transporte {
	private int id;
	// TODO: adicionar enum de situacao
	private String situacao;
	private Armazem armazemOrigem;
	private Armazem armazemDestino;
	private Agente agente;
	private Produto produto;

	public Transporte(int id, String situacao, Armazem armazemOrigem, Armazem armazemDestino, Agente agente,
			Produto produto) throws ModelException {
		this.id = id;
		this.setSituacao("Ativo");
		validarArmazens(armazemOrigem, armazemDestino);
		this.armazemOrigem = armazemOrigem;
		this.armazemDestino = armazemDestino;
		this.setAgente(agente);
		this.setProduto(produto);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
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

	/**
	 * @return the armazemOrigem
	 */
	public Armazem getArmazemOrigem() {
		return armazemOrigem;
	}

	/**
	 * @param armazemOrigem the armazemOrigem to set
	 */
	public void setArmazemOrigem(Armazem armazemOrigem) throws ModelException {
		validarArmazens(this.armazemOrigem, this.armazemDestino);
		this.armazemOrigem = armazemOrigem;
	}

	/**
	 * @return the armazemDestino
	 */
	public Armazem getArmazemDestino() {
		return armazemDestino;
	}

	/**
	 * @param armazemDestino the armazemDestino to set
	 */
	public void setArmazemDestino(Armazem armazemDestino) throws ModelException {
		validarArmazens(this.armazemOrigem, this.armazemDestino);
		this.armazemDestino = armazemDestino;
	}

	// TODO: criar exception personalizada para armazens invalidos.
	private static void validarArmazens(Armazem origem, Armazem destino) throws ModelException {
		// Verificações de armazéns
		if (origem.equals(destino)) {
			throw new ModelException("O armazém de destino não pode ser igual ao de origem.");
		}

		if (origem.getCidade().equals(destino.getCidade())) {
			throw new ModelException("Os armazéns de origem e destino devem ser de cidades diferentes.");
		}
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public Produto getProduto() {
		return produto;
	}

	// TODO: adicionar lancamento de exception para caso o produto esteja bloqueado.
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
