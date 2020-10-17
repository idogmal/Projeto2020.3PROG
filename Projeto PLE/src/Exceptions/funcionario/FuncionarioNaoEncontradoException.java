package Exceptions.funcionario;

public class FuncionarioNaoEncontradoException extends Exception{
    private String cpf;

    public FuncionarioNaoEncontradoException(String cpf) {
        super("funcionario n�o foi encontrado!!!");
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
}