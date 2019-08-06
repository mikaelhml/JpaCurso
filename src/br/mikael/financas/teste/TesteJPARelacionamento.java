package br.mikael.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.mikael.financas.modelo.Conta;
import br.mikael.financas.modelo.Movimentacao;
import br.mikael.financas.modelo.TipoMovimentacao;
import br.mikael.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("002");
		conta.setBanco("BB");
		conta.setNumero("50");
		conta.setTitular("Paulo");
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Saque Para Teste");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("600.698"));
		movimentacao.setConta(conta);
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();
	}
}
