package Exceptions.funcionario;

public class FuncionarioNaoEncontradoException extends Exception{
    private String cpf;

    public FuncionarioNaoEncontradoException(String cpf) {
        super("funcionario não foi encontrado!!!");
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
}