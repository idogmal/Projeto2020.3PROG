package Facade.exception.devolucao;

public class DevolucaoNaoEncontradaException extends Exception {

	private int id;

	public DevolucaoNaoEncontradaException(int id) {
		super("Devolução não encontrada!");
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
