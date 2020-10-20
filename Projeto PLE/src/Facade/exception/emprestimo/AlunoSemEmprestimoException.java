package Facade.exception.emprestimo;

public class AlunoSemEmprestimoException extends Exception {
	private String cpf;

	public AlunoSemEmprestimoException(String cpf) {
		super("Aluno sem empr�stimos em aberto!");
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}
}
