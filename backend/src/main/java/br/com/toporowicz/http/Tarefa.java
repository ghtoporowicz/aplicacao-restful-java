package br.com.toporowicz.http;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tarefa {
	
	private int idTarefa;
	private String nome;
	private String descricao;
	private Date dataCriacao;
	private Date dataLimite;
	private String statusTarefa;

	public Tarefa() {
		
	}
	
	public Tarefa(int idTarefa, String nome, String descricao,
			      Date dataCriacao, Date dataLimite, String statusTarefa) {
		super();
		this.idTarefa = idTarefa;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataLimite = dataLimite;
		this.statusTarefa = statusTarefa;
	}

	public int getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}

	public String getStatusTarefa() {
		return statusTarefa;
	}

	public void setStatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}
}
