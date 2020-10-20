package Facade.exception.devolucao;

public class DevolucaoJaExisteException extends Exception {

	private int id;

	public DevolucaoJaExisteException(int id) {
		super("Devolução já existente!");
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
