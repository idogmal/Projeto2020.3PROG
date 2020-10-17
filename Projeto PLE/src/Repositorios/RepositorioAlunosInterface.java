package Repositorios;

import Entidades.Aluno;


public interface RepositorioAlunosInterface {
    void cadastrar(Aluno aluno);
    void atualizar(Aluno aluno);
    void remover(String cpf);
    Aluno consultar(String cpf);
}
