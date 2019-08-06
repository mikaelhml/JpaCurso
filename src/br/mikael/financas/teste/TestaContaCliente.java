package br.mikael.financas.teste;

import javax.persistence.EntityManager;

import br.mikael.financas.modelo.Cliente;
import br.mikael.financas.modelo.Conta;
import br.mikael.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {

		Cliente cliente = new Cliente();
		cliente.setNome("Pedro");
		cliente.setProfissao("Pedreiro");

		
		Conta conta = new Conta();
		conta.setId(2);
		
		cliente.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		
		em.getTransaction().commit();
		em.close();
		
	}

}
