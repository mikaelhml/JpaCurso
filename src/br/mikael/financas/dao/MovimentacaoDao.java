package br.mikael.financas.dao;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.mikael.financas.modelo.Conta;
import br.mikael.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {
			private EntityManager em;
			
			public MovimentacaoDao(EntityManager em) {
				this.em = em;
			}
			
			
			
			
			public BigDecimal getMaiorValorMovimentacaoTipo(TipoMovimentacao entrada, Conta conta) {
				

				String jpql = "select max(m.valor) from Movimentacao m where m.conta = :pConta" 
						+ " and m.tipo = :pTipo" 
						+ " order by m.valor desc";
						
						
						Query query = em.createQuery(jpql);
						query.setParameter("pConta", conta);
						query.setParameter("pTipo",entrada);
						BigDecimal bigDecimal =  (BigDecimal) query.getSingleResult();
				return bigDecimal;
			}

}
