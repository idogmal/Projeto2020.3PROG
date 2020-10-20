package Entidades;


import java.io.Serializable;

public class Item implements Serializable{
	
	@Override
	public String toString() {
		return livro.getTitulo() + ": " + quantidade;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1833993804381812501L;
	private int id = 0;
	private Livro livro;
	private int quantidade;
	private static int contador = 0;
	
	public Item(Livro livro, int quantidade) {
		Item.contador++;
		this.livro = livro;
		this.quantidade = quantidade;
		this.id = contador;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}



