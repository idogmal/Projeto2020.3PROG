package Controle;

import Entidades.Devolucao;
import Exceptions.devolucao.DevolucaoJaExistenteException;
import Exceptions.devolucao.DevolucaoNaoEncontradaException;
import Exceptions.devolucao.DevolucaoNulaException;
import Repositorios.RepositorioDevolucoes;

public class ControleDevolucao {
    private RepositorioDevolucoes devolucoes;

    public ControleDevolucao(RepositorioDevolucoes devolucoes) {
        this.devolucoes = devolucoes;
    }
    
    public void cadastrar(Devolucao devolucao)throws DevolucaoJaExistenteException,DevolucaoNulaException{
        if(devolucao.getAluno()!=null && devolucao.getLivro()!=null && devolucao.getFuncionario()!=null){
            if(devolucoes.consultar(devolucao.getId()) == null){
                devolucoes.cadastrar(devolucao);
            }
            else{
                DevolucaoJaExistenteException e = new DevolucaoJaExistenteException(devolucao.getId());
                throw e;
            }
        }
        else{
            DevolucaoNulaException e  = new DevolucaoNulaException(devolucao.getAluno(), devolucao.getLivro(), devolucao.getFuncionario());
            throw e;
        }
    }
    
    public void remover(int id) throws DevolucaoNaoEncontradaException{
       Devolucao devolucao = devolucoes.consultar(id);
        if(devolucao == null){
            DevolucaoNaoEncontradaException e = new DevolucaoNaoEncontradaException(id);
            throw e;
        }
        else{
            devolucoes.remover(id);
        }
    }
    
    public Devolucao consultar(int id) throws DevolucaoNaoEncontradaException{
        Devolucao devolucao = devolucoes.consultar(id);
        if(devolucao == null){
          DevolucaoNaoEncontradaException e = new DevolucaoNaoEncontradaException(id);
          throw e;
        }
        else{
            return devolucao;
        }
    }
    
 
}