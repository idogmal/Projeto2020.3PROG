package Repositorios;

import Entidades.Emprestimo;

public interface RepositorioEmprestimosInterface {
    void cadastrar(Emprestimo emprestimo);
    void remover(int id);
    Emprestimo consultar(int id);
}