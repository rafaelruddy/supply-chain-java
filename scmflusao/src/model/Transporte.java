package model;

public class Transporte {
	private int id;
	private StatusTransporte situacao;
	private Armazem armazemOrigem;
	private Armazem armazemDestino;
	private Agente agente;
	private Produto produto;

	public Transporte(int id, String situacao, Armazem armazemOrigem, Armazem armazemDestino, Agente agente,
			Produto produto) throws ModelException {
		this.id = id;
		this.setSituacao(StatusTransporte.AGUARDANDO_APROVAÇÃO);
		validarArmazens(armazemOrigem, armazemDestino);
		this.armazemOrigem = armazemOrigem;
		this.armazemDestino = armazemDestino;
		this.setAgente(agente);
		this.setProduto(produto);
	}

	public static enum StatusTransporte {
		AGUARDANDO_APROVAÇÃO, REPROVADO, CANCELADO, ATIVO, FINALIZADO, BLOQUEADO
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
	public StatusTransporte getSituacao() {
		return situacao;
	}

	/**
	 * @param situacao the situacao to set
	 */
	public void setSituacao(StatusTransporte situacao) {
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
		validarArmazens(armazemOrigem, this.armazemDestino);
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
		validarArmazens(this.armazemOrigem, armazemDestino);
		this.armazemDestino = armazemDestino;
	}

	private static void validarArmazens(Armazem origem, Armazem destino) throws ModelException {
		// Verificações de armazéns
		
		if (origem == null || destino == null) {
			throw new ModelException("Os armazéns de origem e destino não podem ser nulos.");
		}  
		
		if (origem.equals(destino)) {
			throw new ModelException("O armazém de destino não pode ser igual ao de origem.");
		}

		if (origem.getCidade().equals(destino.getCidade())) {
			throw new ModelException("Os armazéns de origem e destino devem ser de cidades diferentes.");
		}

		if (origem.getSituacao() != Armazem.StatusArmazem.ATIVO
				|| destino.getSituacao() != Armazem.StatusArmazem.ATIVO) {
			throw new ModelException("Os armazéns de origem e destino devem ter o status ativo.");
		}
		
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) throws ModelException {
		if (agente == null) {
			throw new ModelException("O agente não pode ser nulo.");
		}  
		
		if (agente.getSituacao() != Agente.StatusAgente.ATIVO ) {
			throw new ModelException("O agente deve ter o status ativo.");
		}
		
		this.agente = agente;
	}

	public Produto getProduto() {
		return produto;
	}
 
	public void setProduto(Produto produto) throws ModelException {
		if (produto == null) {
			throw new ModelException("O produto não pode ser nulo.");
		}  
		
		if (produto.getSituacao() != Produto.StatusProduto.ATIVO) {
			throw new ModelException("O produto deve ter o status ativo.");
		}
		
		this.produto = produto;
	}
}
