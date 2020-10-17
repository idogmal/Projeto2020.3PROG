package Controle;

import Entidades.Funcionario;
import Exceptions.aluno.CpfJaExistenteException;
import Exceptions.funcionario.FuncionarioNaoEncontradoException;
import Exceptions.funcionario.FuncionarioNuloException;
import Repositorios.RepositorioFuncionarios;

public class ControleFuncionario {
    private RepositorioFuncionarios funcionarios;

    public ControleFuncionario(RepositorioFuncionarios funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public void cadastrar(Funcionario funcionario)throws CpfJaExistenteException, FuncionarioNuloException{
        if(funcionario.getNome()!=null && funcionario.getCpf()!=null && funcionario.getSenha()!=null){
           if(funcionarios.consultar(funcionario.getCpf())== null){
               funcionarios.cadastrar(funcionario);
           }
           else{
               CpfJaExistenteException e = new CpfJaExistenteException(funcionario.getCpf());
               throw e;
           }
        }
        else{
            FuncionarioNuloException e = new FuncionarioNuloException(funcionario.getNome(), funcionario.getCpf(), funcionario.getSenha());
            throw e;
        }
    }
    public void remover(String cpf)throws FuncionarioNaoEncontradoException{
        Funcionario funcionario = funcionarios.consultar(cpf);
        if(funcionario==null){
            FuncionarioNaoEncontradoException e = new FuncionarioNaoEncontradoException(cpf);
            throw e;
        }
        else{
            funcionarios.remover(cpf);
        }
    }
    
   public void atualizar(Funcionario funcionario)throws FuncionarioNaoEncontradoException{
       Funcionario funcionarioAux = funcionarios.consultar(funcionario.getCpf());
      if(funcionarioAux==null || funcionario==null){
          FuncionarioNaoEncontradoException e = new FuncionarioNaoEncontradoException(funcionario.getCpf());
          throw e;
      }
      else{
          funcionarios.atualizar(funcionario);
      }
   } 
   public Funcionario consultar(String cpf)throws FuncionarioNaoEncontradoException{
       Funcionario funcionario = funcionarios.consultar(cpf);
       if(funcionario == null){
           FuncionarioNaoEncontradoException e = new FuncionarioNaoEncontradoException(cpf);
           throw e;
       }
       else{
       return funcionario;
       }    
   }
   
   public boolean validarFuncionario(String cpf, String senha)throws FuncionarioNaoEncontradoException{
       boolean resultado = funcionarios.validarFuncionario(cpf, senha);
       if(resultado == false){
           FuncionarioNaoEncontradoException e = new FuncionarioNaoEncontradoException(cpf);
           throw e;
       }
       else{
           return resultado;
       }
   }
}
