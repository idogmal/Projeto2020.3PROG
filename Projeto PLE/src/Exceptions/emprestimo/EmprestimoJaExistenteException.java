package Exceptions.emprestimo;

public class EmprestimoJaExistenteException extends Exception{
    private int id;

    public EmprestimoJaExistenteException(int id) {
        super("O emprestimo já EXISTE!!!");
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}
