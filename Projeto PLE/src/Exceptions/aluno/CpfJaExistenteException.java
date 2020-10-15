package Exceptions.aluno;


public class CpfJaExistenteException extends Exception{

    private String cpf;

    public CpfJaExistenteException(String cpf) {
        super("CPF J� FOI CADASTRADO!!!");
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
}
