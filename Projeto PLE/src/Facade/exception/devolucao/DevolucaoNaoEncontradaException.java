package Facade.exception.devolucao;

public class DevolucaoNaoEncontradaException extends Exception {

	private int id;

	public DevolucaoNaoEncontradaException(int id) {
		super("Devolu��o n�o encontrada!");
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
