package Exceptions.livro;

public class LivroNuloException extends Exception{
    private String autor;
    private String titulo;
    private int id;

    public LivroNuloException(String autor, String titulo, int id) {
        super("Autor, titulo e/ou id não preenchidos!!!");
        this.autor = autor;
        this.titulo = titulo;
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }
    
    
}