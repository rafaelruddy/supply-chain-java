package model;

public class Agente {
	private int id;
	private String nome;
	private String codigo;
	private String cpf;
	//TODO: adicionar enum de situacao
	private String situacao;
	private EmpresaParceira empresa;
	
	public Agente(int id, String nome, String codigo, String cpf, EmpresaParceira empresa)  throws ModelException {
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.cpf = cpf;
		this.setSituacao("Ativo");
		this.setEmpresa(empresa);
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
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public EmpresaParceira getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaParceira empresa)  throws ModelException {
		if (empresa == null) {
			throw new ModelException("A cidade deve pertencer a um país.");
		}
		this.empresa = empresa;
		empresa.adicionarAgente(this);
	}
	
}
