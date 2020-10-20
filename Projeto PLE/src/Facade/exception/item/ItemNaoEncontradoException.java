package Facade.exception.item;

public class ItemNaoEncontradoException extends Exception {

	private int id;

	public ItemNaoEncontradoException(int id) {
		super("Item n�o encontrado!");
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
