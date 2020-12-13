package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class TestaMovimentacaoDao {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("conta");
		EntityManager em = emf.createEntityManager();
		
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);

		// SOMA
		System.out.println("A soma das movimentações é: " + movimentacaoDao.getSomaDasMovimentacoes());
	
		// MEDIA Total de todas as Movimentações
		System.out.println("A média de todas as movimentações é: " + movimentacaoDao.getMediaDeTodasMovimentacoes());
		
		// MÉDIA com datas das Movimentações
		List<MediaComData> mediaDasMovimentacoes = movimentacaoDao.getMediaDasMovimentacoesPorDia();
		for (MediaComData mediaComData : mediaDasMovimentacoes) {
			System.out.println("A média do dia " + mediaComData.getDia() + "/" + mediaComData.getMes() + " é: " + mediaComData.getValor());
		}
	}
	
}
