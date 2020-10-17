package Controle;

import Entidades.Emprestimo;
import Exceptions.emprestimo.EmprestimoJaExistenteException;
import Exceptions.emprestimo.EmprestimoNaoEncontradoException;
import Exceptions.emprestimo.EmprestimoNuloException;
import Repositorios.RepositorioEmprestimos;

public class ControleEmprestimo {
    
    private RepositorioEmprestimos emprestimos;

    public ControleEmprestimo(RepositorioEmprestimos emprestimos) {
        this.emprestimos = emprestimos;
    }
    
    public void cadastrar(Emprestimo emprestimo)throws EmprestimoJaExistenteException, EmprestimoNuloException{
        if(emprestimo.getAluno()!=null && emprestimo.getFuncionario()!=null && emprestimo.getLivro() != null){
           if(emprestimos.consultar(emprestimo.getId())==null) {
               emprestimos.cadastrar(emprestimo);
           }
           else{
               EmprestimoJaExistenteException e = new EmprestimoJaExistenteException(emprestimo.getId());
               throw e;
           }
        }
    else{
    EmprestimoNuloException e = new EmprestimoNuloException(emprestimo.getAluno(), emprestimo.getFuncionario(), emprestimo.getLivro());
    throw e;
        } 
    }
    
    public void remover(int id) throws EmprestimoNaoEncontradoException{
        Emprestimo emprestimo = emprestimos.consultar(id);
        if(emprestimo==null){
            EmprestimoNaoEncontradoException e = new EmprestimoNaoEncontradoException(id);
            throw e;
        }
        else{
            emprestimos.remover(id);
        }
    }
    public Emprestimo consultar(int id) throws EmprestimoNaoEncontradoException{
        Emprestimo emprestimo = emprestimos.consultar(id);
        if(emprestimo == null){
            EmprestimoNaoEncontradoException e = new EmprestimoNaoEncontradoException(id);
            throw e;
        }
        else{
            return emprestimo;
        }
    }
    
}
