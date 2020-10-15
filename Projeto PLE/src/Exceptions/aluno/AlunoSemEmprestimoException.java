package Exceptions.aluno;


public class AlunoSemEmprestimoException extends Exception {
    private final String cpf;

    public AlunoSemEmprestimoException(String cpf) {
        super("Aluno n�o possui empr�stimo de livros!!!");
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
    
    
    
}
