package Exceptions.emprestimo;

public class EmprestimoNaoEncontradoException extends Exception {
    private int id;

    public EmprestimoNaoEncontradoException(int id) {
        super("Emprestimo não encontrado!!!");
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}
