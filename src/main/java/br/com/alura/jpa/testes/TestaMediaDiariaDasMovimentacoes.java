package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class TestaMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("conta");
		EntityManager em = emf.createEntityManager();
		
		List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDao(em).getMediaDasMovimentacoesPorDia();
	
		for (MediaComData mediaComData : mediaDasMovimentacoes) {
			System.out.println("A média das movimentações do dia: " + mediaComData.getDia() + "/" + mediaComData.getMes() + " é: " + mediaComData.getValor());
		}
	}
}
