package Repositorio;

import java.util.ArrayList;

import Entidades.Emprestimo;

public interface RepositorioEmprestimos {

	public void cadastrar(Emprestimo emprestimo);

	public void remover(int id);

	public Emprestimo consultar(int id);

	public ArrayList<Emprestimo> procurarEmprestimos(String cpf);

	public ArrayList<Emprestimo> listar();

	public void salvarArquivo();
}
