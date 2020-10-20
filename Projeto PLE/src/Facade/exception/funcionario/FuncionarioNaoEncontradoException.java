package Facade.exception.funcionario;

public class FuncionarioNaoEncontradoException extends Exception {

	private String cpf;

	public FuncionarioNaoEncontradoException(String cpf) {
		super("Funcionário não encontrado!");
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

}
