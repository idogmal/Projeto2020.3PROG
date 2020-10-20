package Repositorio;

import java.util.ArrayList;

import Entidades.Aluno;

public interface RepositorioAlunos {

	public void cadastrar(Aluno aluno);

	public Aluno consultar(String cpf);

	public void remover(String cpf);

	public void atualizar(Aluno aluno);

	public ArrayList<Aluno> listar();

	public void salvarArquivo();
}
