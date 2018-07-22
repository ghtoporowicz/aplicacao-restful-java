package br.com.toporowicz.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.toporowicz.entity.TarefaEntity;

public class TarefaRepository {
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;

	public TarefaRepository(){
		 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("db_estudo");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	/** CRIA UM NOVO REGISTRO NO BANCO DE DADOS **/
	public void Salvar(TarefaEntity tarefaEntity){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(tarefaEntity);
		this.entityManager.getTransaction().commit();
	}
	
	/** ALTERA UM REGISTRO CADASTRADO **/
	public void Alterar(TarefaEntity tarefaEntity){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(tarefaEntity);
		this.entityManager.getTransaction().commit();
	}
	
	/**	RETORNA TODAS AS TAREFAS CADASTRADAS NO BANCO DE DADOS **/
	@SuppressWarnings("unchecked")
	public List<TarefaEntity> TodasTarefas(){
		
		return this.entityManager.createQuery("SELECT t FROM TarefaEntity t ORDER BY t.nome").getResultList();
	}
	
	/** CONSULTA UMA TAREFA CADASTRA PELO ID **/
	public TarefaEntity GetTarefa(Integer idTarefa){
 
		return this.entityManager.find(TarefaEntity.class, idTarefa);
	}
	
	/**	EXCLUINDO UM REGISTRO PELO CÓDIGO **/
	public void Excluir(Integer idTarefa){
 
		TarefaEntity tarefa = this.GetTarefa(idTarefa);
 
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(tarefa);
		this.entityManager.getTransaction().commit();
	}
}