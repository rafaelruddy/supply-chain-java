package controller;

import model.*;

public class CtrlPrograma {

	public static void main(String[] args) {
		try {
            // Criando um país
            Pais brasil = new Pais(1, "Brasil", "BR");

            // Criando uma cidade pertencente ao país
            Cidade saoPaulo = new Cidade(1, "São Paulo", "SP", brasil);
            Cidade rioDeJaneiro = new Cidade(2, "Rio de Janeiro", "RJ", brasil);

            // Criando um armazém na cidade de São Paulo
            Armazem armazemSP = new Armazem(1, "Armazém São Paulo", "Av. Paulista, 1000", saoPaulo);

            // Criando outro armazém na cidade de São Paulo
            Armazem armazemRJ = new Armazem(2, "Armazém Rio de Janeiro", "Rua da Praia, 300", rioDeJaneiro);

            // Criando um produto na cidade de São Paulo
            Produto celular = new Produto(1, "Celular", "Smartphone top de linha", 2500.0, saoPaulo);

            // Criando uma empresa parceira
            EmpresaParceira empresa = new EmpresaParceira(1, "Transportes Rápidos Ltda.", "12345678901234");

            // Criando um agente associado à empresa parceira
            Agente agente = new Agente(1, "Jorge Amado", "AG001", "123.456.789-00", empresa);

            // Criando um transporte do armazém de origem para o de destino
            Transporte transporte = new Transporte(1, "Ativo", armazemSP, armazemRJ, agente, celular);

            // Exibindo informações para verificar se foram criados corretamente
            System.out.println("País: " + brasil.getNome());
            System.out.println("Cidade: " + saoPaulo.getNome() + ", Estado: " + saoPaulo.getEstado());
            System.out.println("Armazém Origem: " + transporte.getArmazemOrigem().getNome() + ", Endereço: " + transporte.getArmazemOrigem().getEndereco());
            System.out.println("Armazém Destino: " + transporte.getArmazemDestino().getNome() + ", Endereço: " + transporte.getArmazemDestino().getEndereco());
            System.out.println("Produto: " + celular.getNome() + ", Preço: R$" + celular.getPreco());
            System.out.println("Empresa Parceira: " + empresa.getNome() + ", CNPJ: " + empresa.getCnpj());
            System.out.println("Agente: " + agente.getNome() + ", Código: " + agente.getCodigo() + ", CPF: " + agente.getCpf());

        } catch (ModelException e) {
            System.out.println("Erro ao criar modelo: " + e.getMessage());
        }

	}

}
