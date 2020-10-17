package Controle;

import Entidades.Devolucao;
import Entidades.Emprestimo;
import Entidades.Livro;
import Exceptions.livro.LivroJaExistenteException;
import Exceptions.livro.LivroNaoEmprestavelException;
import Exceptions.livro.LivroNaoEncontradoException;
import Exceptions.livro.LivroNuloException;
import Repositorios.RepositorioLivros;

public class ControleLivro {
    private RepositorioLivros livros;

    public ControleLivro(RepositorioLivros livros) {
        this.livros = livros;
    }
    
    public void cadastrar(Livro livro) throws LivroJaExistenteException, LivroNuloException{
        if(livro.getAutor()!=null && livro.getId()>=0 && livro.getTitulo()!=null){
            if(livros.consultar(livro.getId()) == null){
                livros.cadastrar(livro);
            }
            else{
                LivroJaExistenteException e = new LivroJaExistenteException(livro.getId(), livro.getTitulo());
                    throw e;
                  }
            }  
        else{
            LivroNuloException e = new LivroNuloException(livro.getAutor(), livro.getTitulo(), livro.getId());
             throw e;      
        }
    }
    
    public void atualizarEstoqueEmprestimo(Emprestimo emprestimo) throws LivroNaoEmprestavelException{
       
        Livro livro = emprestimo.getLivro();
            if(livro!=null && livro.getQuantidade()<=livro.getEstoque()){
                livros.atualizarEstoqueEmprestimo(livro);
            }
            else{
                LivroNaoEmprestavelException e = new LivroNaoEmprestavelException(livro);
                throw e;
        }
               
    }
    
    public void atualizarEstoqueDevolucao(Devolucao devolucao) {
	Livro livro = devolucao.getLivro();
		if (livros != null)
	        livros.atualizarEstoqueDevolucao(livro);	
		
	}
    
    public void remover(int id) throws LivroNaoEncontradoException{
        Livro livro = livros.consultar(id);
        if(livro == null){
            LivroNaoEncontradoException e = new LivroNaoEncontradoException(id);
            throw e;
        }
        else{
            livros.remover(id);
        }
    }
    public void atualizar(Livro livro)throws LivroNaoEncontradoException{
       Livro livroAux = livros.consultar(livro.getId());
       if(livroAux == null || livro == null){
           LivroNaoEncontradoException e = new LivroNaoEncontradoException(livro.getId());
           throw e;
       }
       else{
           livros.atualizar(livro);
       }
     }
    public void consultar(int id)throws LivroNaoEncontradoException{
        Livro livro = livros.consultar(id);
        if(livro == null){
            LivroNaoEncontradoException e = new LivroNaoEncontradoException(id);
            throw e;
        }
        else{
            livros.consultar(id);
        }
    }
}
