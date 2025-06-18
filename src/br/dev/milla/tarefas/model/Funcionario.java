package br.dev.milla.tarefas.model;

public class Funcionario {

	private String nome;
	private String telefone;
	private String email;
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String formatarArq() {
		return this.codigo + "," + this.nome + "," + this.telefone + "," + this.email + "\n";
	}
	
}
