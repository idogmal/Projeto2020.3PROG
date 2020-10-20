package Repositorio;

import java.util.ArrayList;

import Entidades.Funcionario;

public interface RepositorioFuncionarios {

	public void cadastrar(Funcionario funcionario);

	public void remover(String cpf);

	public void atualizar(Funcionario funcionario);

	public Funcionario consultar(String cpf);

	public ArrayList<Funcionario> listar();

	public void salvarArquivo();

	public boolean validarFuncionario(String cpf, String senha);
}
