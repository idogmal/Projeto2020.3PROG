package Facade.exception.aluno;

public class CpfJaExisteException extends Exception {

	private String cpf;

	public CpfJaExisteException(String cpf) {
		super("Cpf j� cadastrado!");
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

}
