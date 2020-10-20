package Facade.exception.item;

import Entidades.Livro;

public class ItemNuloException extends Exception {

	private Livro livro;
	private int quantidade;

	public ItemNuloException(Livro livro, int quantidade) {
		super("Livro e/ou quantidade nulos!");
		this.livro = livro;
		this.quantidade = quantidade;
	}

	public Livro getLivro() {
		return livro;
	}

	public int getQuatidade() {
		return quantidade;
	}

}
