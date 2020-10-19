package Facade;

import Controle.ControleAluno;
import Controle.ControleDevolucao;
import Controle.ControleEmprestimo;
import Controle.ControleFuncionario;
import Controle.ControleLivro;
import Entidades.Aluno;
import Entidades.Devolucao;
import Entidades.Emprestimo;
import Entidades.Funcionario;
import Entidades.Livro;
import Exceptions.aluno.AlunoNaoEncontradoException;
import Exceptions.aluno.AlunoNuloException;
import Exceptions.aluno.CpfJaExistenteException;
import Exceptions.devolucao.DevolucaoJaExistenteException;
import Exceptions.devolucao.DevolucaoNaoEncontradaException;
import Exceptions.devolucao.DevolucaoNulaException;
import Exceptions.emprestimo.EmprestimoJaExistenteException;
import Exceptions.emprestimo.EmprestimoNaoEncontradoException;
import Exceptions.emprestimo.EmprestimoNuloException;
import Exceptions.funcionario.FuncionarioNaoEncontradoException;
import Exceptions.funcionario.FuncionarioNuloException;
import Exceptions.livro.LivroJaExistenteException;
import Exceptions.livro.LivroNaoEmprestavelException;
import Exceptions.livro.LivroNaoEncontradoException;
import Exceptions.livro.LivroNuloException;

public class Fachada {
    private ControleAluno alunos;
    private ControleDevolucao devolucoes;
    private ControleEmprestimo emprestimos;
    private ControleFuncionario funcionarios;
    private ControleLivro livros;
    
    private static Fachada instance;

    private Fachada() {
        this.alunos = alunos;
        this.devolucoes = devolucoes;
        this.emprestimos = emprestimos;
        this.funcionarios = funcionarios;
        this.livros = livros;
    }
    
    public static Fachada getInstance(){
        if(Fachada.instance == null){
            Fachada.instance = new Fachada();
          
        }
        return instance;
    }
    
    public void cadastrar(Aluno aluno)throws CpfJaExistenteException, AlunoNuloException {
        alunos.cadastrar(aluno);
    }
    
    public void remover(String cpf)throws AlunoNaoEncontradoException{
      alunos.remover(cpf);
    }
    
    public void atualizar(Aluno aluno)throws AlunoNaoEncontradoException{
        alunos.atualizar(aluno);
    }
    
    public Aluno consultar(String cpf) throws AlunoNaoEncontradoException{
        return alunos.consultar(cpf);
    }
    
    public void cadastrar(Devolucao devolucao)throws DevolucaoJaExistenteException, DevolucaoNulaException{
        devolucoes.cadastrar(devolucao);
    }
    
    public void removerDevolucao(int id)throws DevolucaoNaoEncontradaException{
        devolucoes.remover(id);
    }
    
    public void consultarDevolucao(int id) throws DevolucaoNaoEncontradaException{
        devolucoes.consultar(id);
    }
    
    public  void cadastrarEmprestimo(Emprestimo emprestimo)throws EmprestimoJaExistenteException, EmprestimoNuloException{
        emprestimos.cadastrar(emprestimo);
    }
    
    public void removerEmprestimo(int id)throws EmprestimoNaoEncontradoException{
        emprestimos.remover(id);
    }
    
    public  Emprestimo consultarEmprestimo(int id)throws EmprestimoNaoEncontradoException{
        return emprestimos.consultar(id);
    }
    
    public void cadastrar(Funcionario funcionario) throws CpfJaExistenteException, FuncionarioNuloException{
        funcionarios.cadastrar(funcionario);
    }
    
    public void removerFuncionario(String cpf) throws FuncionarioNaoEncontradoException{
        funcionarios.remover(cpf);
    }
    
    public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException{
        funcionarios.atualizar(funcionario);
    }
    
    public void consultarFuncionario(String cpf) throws FuncionarioNaoEncontradoException{
        funcionarios.consultar(cpf);
    }
    
    public void validarFuncionario(String cpf, String senha) throws FuncionarioNaoEncontradoException{
        funcionarios.validarFuncionario(cpf, senha);
    }
    
    
    public void cadastrar(Livro livro) throws LivroJaExistenteException, LivroNuloException{
        livros.cadastrar(livro);
    }
    
    public void removerLivro(int id) throws LivroNaoEncontradoException{
        livros.remover(id);
    }
    
    public void atualizarLivro(Livro livro) throws LivroNaoEncontradoException{
        livros.atualizar(livro);
    }
    
    public void atualizarEstoqueEmprestimo(Emprestimo emprestimo) throws LivroNaoEmprestavelException, LivroJaExistenteException{
        livros.atualizarEstoqueEmprestimo(emprestimo);
    }
    
    public void atualizarEstoqueDevolucao(Devolucao devolucao){
        livros.atualizarEstoqueDevolucao(devolucao);
    }

   
}
