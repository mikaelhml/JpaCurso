package br.mikael.financas.teste;

import javax.persistence.EntityManager;

import br.mikael.financas.modelo.Conta;
import br.mikael.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class,1);
		
		System.out.println("Conta e: " + conta.getTitular());
		
		em.getTransaction().commit();
	}

}
