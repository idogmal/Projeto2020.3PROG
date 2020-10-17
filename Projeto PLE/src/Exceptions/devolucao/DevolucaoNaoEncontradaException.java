package Exceptions.devolucao;

public class DevolucaoNaoEncontradaException extends Exception{
    private int id;

    public DevolucaoNaoEncontradaException(int id) {
        super("Devolu��o nao encontrada!!!");
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}