package Exceptions.Devolucao;

public class DevolucaoJaExistenteException extends Exception {
    private int id;

    public DevolucaoJaExistenteException(int id) {
        super("Devolução ja Existente!!!");
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    
    
    
    
    
}
