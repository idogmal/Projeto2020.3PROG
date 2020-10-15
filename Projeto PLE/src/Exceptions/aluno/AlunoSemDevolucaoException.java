package Exceptions.aluno;

public class AlunoSemDevolucaoException extends Exception{
    private String cpf;

    public AlunoSemDevolucaoException(String cpf) {
        super("Aluno não possui devoluções!!!");
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
}
