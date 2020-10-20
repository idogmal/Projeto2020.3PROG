package Facade.exception.aluno;

public class AlunoNaoEncontradoException extends Exception{
	
	private String cpf;
	
	public AlunoNaoEncontradoException(String cpf) {
		super("Aluno não encontrado!");
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
	
}
