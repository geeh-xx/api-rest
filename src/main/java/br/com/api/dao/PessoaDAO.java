package br.com.api.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.api.entidade.Pessoa;
import br.com.api.util.Resource;

public class PessoaDAO implements DAO<Pessoa, Long>{
	
	@Inject
	EntityManager em = Resource.getSession();

	public Pessoa insert(Pessoa t) throws Exception  {
		
		if(findByLogin(t.getLogin())){
			em.persist(t);
			em.getTransaction().commit();
		}else{
			
			throw new Exception ("Login Ja existente");
		}
	
		return t;
	}

	public Pessoa update(Pessoa t) throws Exception {
	
		if(findByLogin(t.getLogin())){
			em.merge(t);
			em.getTransaction().commit();
		}else{
			throw new Exception ("Login Ja existente");

		}
		
		return t;
	}

	public void delete(Pessoa t) throws Exception {
		em.remove(t);
		em.getTransaction().commit();
	}

	public Pessoa find(Long k) throws Exception {
		return em.find(Pessoa.class, k);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> findAll() throws Exception {
		return em.createQuery("from Pessoa").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> findByName(String name) throws Exception {
		return em.createQuery("select p from Pessoa p where p.nome = :nome").setParameter("nome",name).getResultList();

	}

	@SuppressWarnings("unchecked")
	public boolean findByLogin(String login) throws Exception {
		
		List<Pessoa> lista =  em.createQuery("select p from Pessoa p where p.login = :login").setParameter("login",login).getResultList();
		if (lista.size() > 0) {
			return false;
		}else{
			return true;

		}	
		
	}
	
	@SuppressWarnings("unchecked")
	public Pessoa login(String login, String senha) throws Exception{
		List<Pessoa> lista =  em.createQuery("select p from Pessoa p where p.login = :login and p.senha = :senha")
				.setParameter("login",login).setParameter("senha", senha).getResultList();
		System.out.println(lista.size());
		if (lista.size() > 0) {
			return lista.get(0);
		}else{
			throw new Exception ("Login ou senha invalidos");
		}	
	}
}
