package Repositorio;

import java.util.ArrayList;

import Entidades.Item;
import Entidades.Livro;

public interface RepositorioLivros {

	public void cadastrar(Livro livro);

	public void remover(int id);

	public void atualizar(Livro livro);

	public Livro consultar(int id);

	public ArrayList<Livro> listar();

	public void salvarArquivo();

	public void atualizarEstoqueEmprestimo(Item item);

	public void atualizarEstoqueDevolucao(Item item);

	public boolean consultarEstoque(Item item);
}
