package Exceptions.livro;

public class LivroNaoEncontradoException extends Exception {
    private int id;

    public LivroNaoEncontradoException(int id) {
        super("livro não encontrado!!!");
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    
}
