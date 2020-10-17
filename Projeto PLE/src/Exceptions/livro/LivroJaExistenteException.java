package Exceptions.livro;

public class LivroJaExistenteException extends Exception {
    private int id;
    private String titulo;

    public LivroJaExistenteException(int id, String titulo) {
        super("livro já existente!!!");
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
