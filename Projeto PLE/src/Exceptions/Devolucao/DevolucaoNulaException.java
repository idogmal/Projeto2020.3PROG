package Exceptions.Devolucao;

import Entidades.Aluno;
import Entidades.Funcionario;
import Entidades.Livro;

public class DevolucaoNulaException extends Exception {
    private Aluno aluno;
    private Livro livro;
    private Funcionario funcionario;

    public DevolucaoNulaException(Aluno aluno, Livro livro, Funcionario funcionario) {
        super("aluno, livro e/ou Funcionarios nulos!!!");
        this.aluno = aluno;
        this.livro = livro;
        this.funcionario = funcionario;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Livro getLivro() {
        return livro;
    }

    
    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    
}
