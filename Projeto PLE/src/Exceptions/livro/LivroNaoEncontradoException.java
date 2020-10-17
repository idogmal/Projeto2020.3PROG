package Exceptions.livro;

public class LivroNaoEncontradoException extends Exception {
    private int id;

    public LivroNaoEncontradoException(int id) {
        super("livro n�o encontrado!!!");
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    
}
