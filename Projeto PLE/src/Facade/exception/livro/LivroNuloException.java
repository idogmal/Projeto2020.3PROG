package Facade.exception.livro;

public class LivroNuloException extends Exception {

	private String autor;
	private String titulo;
	private int id;

	public LivroNuloException(String autor, String titulo, int id) {
		super("Autor, T�tulo e/ou Id n�o preenchidos!");
		this.autor = autor;
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

}
