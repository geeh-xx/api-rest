package br.com.api.ws;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.api.dao.PessoaDAO;
import br.com.api.entidade.MensagemJogoOnline;
import br.com.api.entidade.Pessoa;
import br.com.api.util.Resource;

@Path("/pessoa")
public class PessoaService {

	@Inject
	PessoaDAO pdao = Resource.getPDAO();

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<Pessoa> getAll() throws Exception {

		return pdao.findAll();
	}

	@GET
	@Path("/mensagem")
	@Produces(MediaType.APPLICATION_XML)
	public MensagemJogoOnline getMensagem() throws Exception {
		MensagemJogoOnline msg = new MensagemJogoOnline();
		
		return msg;
	}
	
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Pessoa getPessoa(@PathParam("id") int id) throws Exception {

		return pdao.find(Long.valueOf(id));
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/save/{nome}/{login}/{senha}")
	public Response insert(@PathParam("nome") String nome,@PathParam("login") String login,@PathParam("senha") String senha) {

		try {
			Pessoa p= new Pessoa(null,nome,login,senha);
			pdao.insert(p);
			return Response.status(Response.Status.CREATED).entity(p).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/{id}")
	public Response update(@PathParam("id") int id,Pessoa p) throws Exception {
		Pessoa p2 = pdao.find(Long.valueOf(id));
		p2.setNome(p.getNome());
		pdao.update(p2);
		return Response.status(Response.Status.ACCEPTED).entity(p).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{id}")
	public Response delete(@PathParam("id") int id) throws Exception {
		Pessoa p = pdao.find(Long.valueOf(id));
		pdao.delete(p);
		return Response.status(Response.Status.ACCEPTED).entity(p).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login/{login}/{senha}")
	public Response login(@PathParam("login") String login,@PathParam("senha") String senha) {

		try {
			Pessoa p = pdao.login(login, senha);
			return Response.status(Response.Status.OK).entity(p).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}


}
