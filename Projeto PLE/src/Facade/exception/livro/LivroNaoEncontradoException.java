package Facade.exception.livro;

public class LivroNaoEncontradoException extends Exception {

	private int id;

	public LivroNaoEncontradoException(int id) {
		super("Livro não encontrado!");
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
