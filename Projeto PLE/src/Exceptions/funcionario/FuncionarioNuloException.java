package Exceptions.funcionario;

public class FuncionarioNuloException extends Exception {
    private String nome;
    private String cpf;
    private String senha;

    public FuncionarioNuloException(String nome, String cpf, String senha) {
        super("nome, cpf e/ou senha não foram preenchidos!!!");
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }
    
    
}
