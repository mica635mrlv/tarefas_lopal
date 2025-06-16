package br.dev.milla.tarefas.model;

import java.time.LocalDateTime;

public class Tarefa {

	private int codigo;
	private String titulo;
	private String descricao;
	private LocalDateTime dataInicio;
	private LocalDateTime prazo;
	private LocalDateTime dataConclusao;
	private Status status;
	private Funcionario responsavel;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getPrazo() {
		return prazo;
	}

	public void setPrazo(LocalDateTime prazo) {
		this.prazo = prazo;
	}

	public LocalDateTime getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDateTime dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}
	
	@Override
	public String toString() {
		return this.codigo + "," + this.titulo + "," + this.descricao + "," + this.dataInicio + "," + this.prazo + "," + this.dataConclusao + "," + this.status + "," + this.responsavel + "\n";
	}

}