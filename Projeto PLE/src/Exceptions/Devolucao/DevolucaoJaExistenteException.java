package Exceptions.Devolucao;

public class DevolucaoJaExistenteException extends Exception {
    private int id;

    public DevolucaoJaExistenteException(int id) {
        super("Devolu��o ja Existente!!!");
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    
    
    
    
    
}
