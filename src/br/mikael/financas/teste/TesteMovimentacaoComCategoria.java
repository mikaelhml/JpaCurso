package br.mikael.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.mikael.financas.modelo.Categoria;
import br.mikael.financas.modelo.Conta;
import br.mikael.financas.modelo.Movimentacao;
import br.mikael.financas.modelo.TipoMovimentacao;
import br.mikael.financas.util.JPAUtil;

public class TesteMovimentacaoComCategoria {
	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria("Viagem");
		
		Categoria categoria2 = new Categoria("Negocios");
		
		Conta conta = new Conta();
		conta.setAgencia("900");
		conta.setBanco("Santo Andre");
		conta.setNumero("0");
		conta.setTitular("Joao Pedro");
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Bla Bla ");
		movimentacao1.setValor(new BigDecimal("500"));
		movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao1.setCategorias(Arrays.asList(categoria1,categoria2));
		movimentacao1.setConta(conta);
		
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Testee Bla ");
		movimentacao2.setValor(new BigDecimal("500888888"));
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao2.setCategorias(Arrays.asList(categoria1));
		movimentacao2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(categoria1);
		em.persist(categoria2);
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		em.close();
		
		
		
	}
}
