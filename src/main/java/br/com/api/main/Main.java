package br.com.api.main;

import java.util.List;

import javax.inject.Inject;

import br.com.api.dao.PessoaDAO;
import br.com.api.entidade.Pessoa;
import br.com.api.util.Resource;

@SuppressWarnings("unused")
public class Main {

	@Inject
	static
	PessoaDAO pdao = Resource.getPDAO();
	
	public static void main(String[] args) throws Exception {
		
		Pessoa pessoa = new Pessoa();

//		pessoa = pdao.find(19L);
//		pessoa.setLogin("teste");
//		pessoa.setSenha("joao");
//		pdao.update(pessoa);
		
		System.out.println(pdao.login("teste", "joao").getNome());
		
//		pessoa = pdao.find(3L);
//		pdao.delete(pessoa);
		
		
//		List<Pessoa> lista = pdao.findAll();
//		
////		for (Pessoa pessoa2 : lista) {
////			
////			System.out.println(pessoa2);
////		}
		
	}
	
}
