package Facade.exception.livro;

public class LivroJaExisteException extends Exception {

	private int id;
	private String titulo;

	public LivroJaExisteException(int id, String titulo) {
		super("Livro já existente!");
		this.id = id;
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

}
