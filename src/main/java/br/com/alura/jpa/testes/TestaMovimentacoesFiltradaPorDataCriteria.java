package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class TestaMovimentacoesFiltradaPorDataCriteria {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("conta");
		EntityManager em = emf.createEntityManager();
		
		MovimentacaoDao dao = new MovimentacaoDao(em);
		List<Movimentacao> movimentacoesFiltradasPorData = dao.getMovimentacoesFiltradasPorData(null, null, null);
		
		for (Movimentacao movimentacao : movimentacoesFiltradasPorData) {
			System.out.println("Descrição -> " + movimentacao.getDescricao());
			System.out.println("Valor -> R$ " + movimentacao.getValor());
			System.out.println("----------------------------------------------");
		}
	}
}
