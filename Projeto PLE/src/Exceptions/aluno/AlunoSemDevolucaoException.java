package Exceptions.aluno;

public class AlunoSemDevolucaoException extends Exception{
    private String cpf;

    public AlunoSemDevolucaoException(String cpf) {
        super("Aluno n�o possui devolu��es!!!");
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
}
