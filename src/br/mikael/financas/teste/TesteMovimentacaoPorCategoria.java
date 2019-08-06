package br.mikael.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.mikael.financas.modelo.Categoria;
import br.mikael.financas.modelo.Movimentacao;
import br.mikael.financas.util.JPAUtil;

public class TesteMovimentacaoPorCategoria {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		
		String jpql = "Select m from Movimentacao m join m.categorias c where c=:pCategoria ";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		List<Movimentacao> resultados = query.getResultList();
		 
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descrição: "+ movimentacao.getDescricao());
			System.out.println("Descrição: "+ movimentacao.getConta().getId());
		}
		
		
		
		em.getTransaction().commit();
		em.close();
	}
}
