package br.mikael.financas.teste;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.mikael.financas.dao.MovimentacaoDao;
import br.mikael.financas.modelo.Conta;
import br.mikael.financas.modelo.Movimentacao;
import br.mikael.financas.modelo.TipoMovimentacao;
import br.mikael.financas.util.JPAUtil;

public class TesteFuncoesJPQL {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		Conta conta = new Conta();
		conta.setId(2);
		
		
		em.getTransaction().begin();
		
		//MovimentacaoDao dao = new MovimentacaoDao(em);
		TypedQuery<BigDecimal> typedQuery = em.createNamedQuery("MaiorValorMovimentacaoTipo",BigDecimal.class);
		typedQuery.setParameter("pTipo",TipoMovimentacao.ENTRADA);
		typedQuery.setParameter("pConta",conta);
		
		BigDecimal bigDecimal = typedQuery.getSingleResult();
				//dao.getMaiorValorMovimentacaoTipo(TipoMovimentacao.ENTRADA,conta);
		System.out.println("A soma e: " + bigDecimal);
		 
		
		
		
		
		em.getTransaction().commit();
		em.close();
	}
}
