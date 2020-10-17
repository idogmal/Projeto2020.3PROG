package Repositorios;

import Entidades.Livro;


public interface RepositorioLivrosInterface {
    void cadastrar(Livro livro);
    void remover(int id);
    Livro consultar(int id);
    void atualizarEstoqueEmprestimo(Livro livro);
    void atualizarEstoqueDevolucao(Livro livro);
}
