package Exceptions.aluno;

public class AlunoNuloException extends Exception{
   
	private String nome;
	private String cpf;

	public AlunoNuloException(String nome, String cpf) {
		super("Cpf e/ou Nome não preenchidos!");
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
}

