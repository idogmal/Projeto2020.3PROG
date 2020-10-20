package Entidades;

import java.io.Serializable;

public class Livro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4009357314069633664L;
	private int id = 0;
	private String titulo;
	private String autor;
	private int estoque;
	
	public Livro(String titulo, String autor, int estoque, int id){
		this.titulo = titulo;
		this.autor = autor;
		this.estoque = estoque;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "" + titulo + ", estoque:" + estoque + "";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
}


