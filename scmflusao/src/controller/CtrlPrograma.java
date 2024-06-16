package controller;

import model.*;

public class CtrlPrograma {

	public static void main(String[] args) {
		try {
            // Criando um pa�s
            Pais brasil = new Pais(1, "Brasil", "BR");

            // Criando uma cidade pertencente ao pa�s
            Cidade saoPaulo = new Cidade(1, "S�o Paulo", "SP", brasil);
            Cidade rioDeJaneiro = new Cidade(2, "Rio de Janeiro", "RJ", brasil);

            // Criando um armaz�m na cidade de S�o Paulo
            Armazem armazemSP = new Armazem(1, "Armaz�m S�o Paulo", "Av. Paulista, 1000", saoPaulo);

            // Criando outro armaz�m na cidade de S�o Paulo
            Armazem armazemRJ = new Armazem(2, "Armaz�m Rio de Janeiro", "Rua da Praia, 300", rioDeJaneiro);

            // Criando um produto na cidade de S�o Paulo
            Produto celular = new Produto(1, "Celular", "Smartphone top de linha", 2500.0, saoPaulo);

            // Criando uma empresa parceira
            EmpresaParceira empresa = new EmpresaParceira(1, "Transportes R�pidos Ltda.", "12345678901234");

            // Criando um agente associado � empresa parceira
            Agente agente = new Agente(1, "Jorge Amado", "AG001", "123.456.789-00", empresa);

            // Criando um transporte do armaz�m de origem para o de destino
            Transporte transporte = new Transporte(1, "Ativo", armazemSP, armazemRJ, agente, celular);

            // Exibindo informa��es para verificar se foram criados corretamente
            System.out.println("Pa�s: " + brasil.getNome());
            System.out.println("Cidade: " + saoPaulo.getNome() + ", Estado: " + saoPaulo.getEstado());
            System.out.println("Armaz�m Origem: " + transporte.getArmazemOrigem().getNome() + ", Endere�o: " + transporte.getArmazemOrigem().getEndereco());
            System.out.println("Armaz�m Destino: " + transporte.getArmazemDestino().getNome() + ", Endere�o: " + transporte.getArmazemDestino().getEndereco());
            System.out.println("Produto: " + celular.getNome() + ", Pre�o: R$" + celular.getPreco());
            System.out.println("Empresa Parceira: " + empresa.getNome() + ", CNPJ: " + empresa.getCnpj());
            System.out.println("Agente: " + agente.getNome() + ", C�digo: " + agente.getCodigo() + ", CPF: " + agente.getCpf());

        } catch (ModelException e) {
            System.out.println("Erro ao criar modelo: " + e.getMessage());
        }

	}

}
