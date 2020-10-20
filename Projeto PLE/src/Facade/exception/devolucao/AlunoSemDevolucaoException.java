package Facade.exception.devolucao;

public class AlunoSemDevolucaoException extends Exception {
	private String cpf;

	public AlunoSemDevolucaoException(String cpf) {
		super("Aluno sem devoluções!");
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}
}
