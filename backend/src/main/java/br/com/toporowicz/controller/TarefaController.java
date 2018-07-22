package br.com.toporowicz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.toporowicz.entity.TarefaEntity;
import br.com.toporowicz.http.Tarefa;
import br.com.toporowicz.repository.TarefaRepository;

@Path("/service")
public class TarefaController {
	private final TarefaRepository repository = new TarefaRepository();
	
	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar 
	 * */ 
	 
	/** Cadastra uma nova tarefa **/
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String Cadastrar(Tarefa tarefa){
 
		TarefaEntity entity = new TarefaEntity();
 
		try {
		
			entity.setNome(tarefa.getNome());
			entity.setDescricao(tarefa.getDescricao());
			entity.setDataCriacao(tarefa.getDataCriacao());
			entity.setDataLimite(tarefa.getDataLimite());
			entity.setStatusTarefa(tarefa.getStatusTarefa());
 
			repository.Salvar(entity);
 
			return "Registro cadastrado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	}
	
	/** Altera uma Tarefa já cadastrada **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/alterar")
	public String Alterar(Tarefa tarefa){
 
		TarefaEntity entity = new TarefaEntity();
 
		try {
			entity.setIdTarefa(tarefa.getIdTarefa());
			entity.setNome(tarefa.getNome());
			entity.setDescricao(tarefa.getDescricao());
			entity.setDataCriacao(tarefa.getDataCriacao());
			entity.setDataLimite(tarefa.getDataLimite());
			entity.setStatusTarefa(tarefa.getStatusTarefa());
			
			repository.Alterar(entity);
 
			return "Registro alterado com sucesso!";
 
		} catch (Exception e) {
			return "Erro ao alterar o registro " + e.getMessage();
		}
	}
	
	/** Lista todas as tarefas cadastradas na base **/
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todasTarefas")
	public List<Tarefa> TodasPessoas(){
 
		List<Tarefa> tarefas =  new ArrayList<Tarefa>();
 
		List<TarefaEntity> listaEntityTarefas = repository.TodasTarefas();
 
		for (TarefaEntity entity : listaEntityTarefas) {
 
			tarefas.add(new Tarefa(entity.getIdTarefa(), entity.getNome(),entity.getDescricao(),
								   entity.getDataCriacao(), entity.getDataLimite(), entity.getStatusTarefa()));
		}
		return tarefas;
	}
	
	/** Busca uma tarefa cadastrada pelo id **/
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/getTarefa/{idTarefa}")
	public Tarefa GetTarefa(@PathParam("idTarefa") Integer idTarefa){
 
		System.out.println("Id buscado: " + idTarefa);
		
		TarefaEntity entity = repository.GetTarefa(idTarefa);
		
		if(entity != null)
			return new Tarefa(entity.getIdTarefa(), entity.getNome(),entity.getDescricao(),
					   entity.getDataCriacao(), entity.getDataLimite(), entity.getStatusTarefa());
 
		return null;
	}
	
	/** Excluindo uma pessoa pelo código **/
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{idTarefa}")	
	public String Excluir(@PathParam("idTarefa") Integer idTarefa){
 
		try {
			repository.Excluir(idTarefa);

			return "Registro excluido com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao excluir o registro! " + e.getMessage();
		}
	}	
}
