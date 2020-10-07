
package Entidades;

import java.time.Instant;
import java.time.LocalDate;



public class Devolucao {
    private int id;
    private static int contador = 0;
    private Aluno aluno;
    private Livro livro;
    private Funcionario funcionario;
    private double multa;
    private LocalDate dataDevolucao;

    /**
     *
     * @param aluno
     * @param livro
     * @param funcionario
     * @param dataDevolucao
     */
    public Devolucao(Aluno aluno, Livro livro,Funcionario funcionario, LocalDate dataDevolucao) {
        
        this.aluno = aluno;
        this.livro = livro;
        this.funcionario = funcionario;
        this.dataDevolucao = LocalDate.now();
        this.id = contador++;
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
        Devolucao.contador = contador;
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

    
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
    
    
    
    
}
