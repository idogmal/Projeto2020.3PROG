package Entidades;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3439512605925445607L;
	
	private String nome;
	private String cpf;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
