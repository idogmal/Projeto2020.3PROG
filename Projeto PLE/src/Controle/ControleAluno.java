package Controle;

import Entidades.Aluno;
import Exceptions.aluno.AlunoNaoEncontradoException;
import Exceptions.aluno.AlunoNuloException;
import Exceptions.aluno.CpfJaExistenteException;
import Repositorios.RepositorioAlunos;

public class ControleAluno {
    private RepositorioAlunos alunos;

    public ControleAluno(RepositorioAlunos alunos) {
        this.alunos = alunos;
    }
    
    
    
    public void cadastrar(Aluno aluno)throws CpfJaExistenteException,AlunoNuloException{
        if(aluno.getNome()!=null && aluno.getCpf().length()==11){
        if((alunos.consultar(aluno.getCpf()))== null){
             alunos.cadastrar(aluno);
            
        }
        else{
            CpfJaExistenteException e = new CpfJaExistenteException(aluno.getCpf());
            throw e;
           
        }
        }
        else{
            AlunoNuloException e = new AlunoNuloException(aluno.getNome(),aluno.getCpf());  
                throw e;
       } 
    }
    public void remover(String cpf)throws AlunoNaoEncontradoException{
        Aluno aluno = alunos.consultar(cpf);
        if(aluno==null){
            AlunoNaoEncontradoException e = new AlunoNaoEncontradoException(cpf);
            throw e;
        }
        else{
            alunos.remover(cpf);
        }
    }
    
    public void atualizar(Aluno aluno)throws AlunoNaoEncontradoException{
        Aluno alunoAux = alunos.consultar(aluno.getCpf());
        if( alunoAux == null || aluno == null){
            AlunoNaoEncontradoException e = new AlunoNaoEncontradoException(aluno.getCpf());
            throw e;
        }
        else{
            alunos.atualizar(aluno);
        }
    }
    
    public Aluno consultar(String cpf)throws AlunoNaoEncontradoException{
        Aluno aluno = alunos.consultar(cpf);
        if(aluno==null){
            AlunoNaoEncontradoException e = new AlunoNaoEncontradoException(cpf);
            throw e;
        }
        else{
          
            return aluno;
        }
    }
}
