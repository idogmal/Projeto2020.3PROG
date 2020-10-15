package Exceptions.aluno;


public class AlunoSemEmprestimoException extends Exception {
    private final String cpf;

    public AlunoSemEmprestimoException(String cpf) {
        super("Aluno não possui empréstimo de livros!!!");
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
    
    
    
}
