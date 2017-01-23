package br.com.api.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Produces;

import br.com.api.dao.PessoaDAO;

public class Resource {
	
	@Produces
	@RequestScoped
	public static EntityManager getSession(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		return em;
	}
	
	public void finaliza(@Disposes EntityManager manager) {
	      manager.close();
	}

	@Produces
	@RequestScoped
	public static PessoaDAO getPDAO(){
		PessoaDAO pdao = new PessoaDAO();
		return pdao;
	}
}
