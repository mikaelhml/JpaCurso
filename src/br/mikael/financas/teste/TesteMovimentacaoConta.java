package br.mikael.financas.teste;

import javax.persistence.EntityManager;

import br.mikael.financas.modelo.Conta;
import br.mikael.financas.modelo.Movimentacao;
import br.mikael.financas.util.JPAUtil;

public class TesteMovimentacaoConta {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Movimentacao movimentacao = em.find(Movimentacao.class,14);
		Conta conta = movimentacao.getConta();
		
		
		System.out.println("Titular da conta: "+ conta.getTitular());
		System.out.println("Numero de movimentacoes: "+ conta.getMovimentacoes().size());
		em.getTransaction().commit();
		em.close();
		
		

	}
}
