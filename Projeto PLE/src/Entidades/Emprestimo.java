
package Entidades;

import java.time.LocalDate;
import java.util.Arrays;


public class Emprestimo {
    private int id = 0;
    private static int contador = 0;
    private Aluno aluno;
    private Livro livro;
    private Funcionario funcionario;
    private LocalDate dataEmprestimo;
    private final LocalDate dataDevolucao;


    public Emprestimo(Aluno aluno, Livro livro, Funcionario funcionario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.aluno = aluno;
        this.livro = livro;
        this.funcionario = funcionario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = this.dataEmprestimo.plusDays(30);      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Emprestimo.contador = contador;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

   

 

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

   

   

    @Override
    public String toString() {
        return "Emprestimo{" + "id=" + id + ", aluno=" + aluno + ", livro=" + livro + ", funcionario=" + funcionario + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + '}';
    }
  

    
    
    
    
    
    
    
}
