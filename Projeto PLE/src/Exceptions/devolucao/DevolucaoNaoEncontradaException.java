package Exceptions.devolucao;

public class DevolucaoNaoEncontradaException extends Exception{
    private int id;

    public DevolucaoNaoEncontradaException(int id) {
        super("Devolução nao encontrada!!!");
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}