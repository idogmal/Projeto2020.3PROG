package Exceptions.emprestimo;

import Entidades.Aluno;
import Entidades.Funcionario;
import Entidades.Livro;

public class EmprestimoNuloException extends Exception {
    private Aluno aluno;
    private Funcionario funcionario;
    private Livro livro;

    public EmprestimoNuloException(Aluno aluno, Funcionario funcionario, Livro livro) {
        super("Aluno, funcionario e/ou livro nulo!!!");
        this.aluno = aluno;
        this.funcionario = funcionario;
        this.livro = livro;
    }
    
    
    
 
    public Aluno getAluno() {
        return aluno;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Livro getLivro() {
        return livro;
    }

  
    
    
}
