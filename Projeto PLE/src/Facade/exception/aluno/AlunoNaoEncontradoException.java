package Facade.exception.aluno;

public class AlunoNaoEncontradoException extends Exception{
	
	private String cpf;
	
	public AlunoNaoEncontradoException(String cpf) {
		super("Aluno n�o encontrado!");
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
	
}
