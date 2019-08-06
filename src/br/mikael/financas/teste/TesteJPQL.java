package br.mikael.financas.teste;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.mikael.financas.modelo.Movimentacao;
import br.mikael.financas.util.JPAUtil;

public class TesteJPQL {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		String jpql = "Select m from Movimentacao m where m.conta.id = 2";
		Query query = em.createQuery(jpql);
		List<Movimentacao> resultados = query.getResultList();
		 
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descrição: "+ movimentacao.getDescricao());
			System.out.println("Descrição: "+ movimentacao.getConta().getId());
		}
		
		
		
		em.getTransaction().commit();
		em.close();
	}
}
