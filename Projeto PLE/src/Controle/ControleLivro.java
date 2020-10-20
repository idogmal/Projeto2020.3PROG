package Controle;

import java.util.ArrayList;

import Entidades.Devolucao;
import Entidades.Emprestimo;
import Entidades.Item;
import Entidades.Livro;
import Facade.exception.livro.LivroJaExisteException;
import Facade.exception.livro.LivroNaoEmprestavelException;
import Facade.exception.livro.LivroNaoEncontradoException;
import Facade.exception.livro.LivroNuloException;
import Repositorio.RepositorioLivros;
import Repositorio.RepositorioLivrosArray;

public class ControleLivro {

	private RepositorioLivros livros;

	public ControleLivro() {
		livros = RepositorioLivrosArray.getInstance();
	}

	public void cadastrar(Livro livro) throws LivroJaExisteException, LivroNuloException {
		if (livro.getTitulo() != null && livro.getAutor() != null && livro.getId() >= 0) {
			if (livros.consultar(livro.getId()) == null) {
				livros.cadastrar(livro);
				RepositorioLivrosArray.getInstance().salvarArquivo();
			} else {
				LivroJaExisteException e = new LivroJaExisteException(livro.getId(), livro.getTitulo());
				throw e;
			}
		} else {
			LivroNuloException e = new LivroNuloException(livro.getAutor(), livro.getTitulo(), livro.getId());
			throw e;
		}
	}

	public void atualizarEstoqueEmprestimo(Emprestimo emprestimo) {
		Item[] itens = emprestimo.getItens();
		for (int i = 0; i < itens.length; i++) {
			if (itens[i] != null) {
				livros.atualizarEstoqueEmprestimo(itens[i]);
			}
		}
	}

	public void atualizarEstoqueDevolucao(Devolucao devolucao) {
		Item[] itens = devolucao.getItens();
		for (int i = 0; i < itens.length; i++) {
			if (itens[i] != null) {
				livros.atualizarEstoqueDevolucao(itens[i]);
			}
		}
	}

	public boolean consultarEstoque(Item item) throws LivroNaoEmprestavelException {
		boolean retorno = livros.consultarEstoque(item);
		if (retorno == false) {
			LivroNaoEmprestavelException e = new LivroNaoEmprestavelException(item);
			throw e;
		}
		return retorno;
	}

	public void remover(int id) throws LivroNaoEncontradoException {
		Livro livro = livros.consultar(id);
		if (livro == null) {
			LivroNaoEncontradoException e = new LivroNaoEncontradoException(id);
			throw e;
		} else {
			livros.remover(id);
			RepositorioLivrosArray.getInstance().salvarArquivo();
		}
	}

	public void atualizar(Livro livro) throws LivroNaoEncontradoException {
		Livro livroAux = livros.consultar(livro.getId());
		if (livro == null || livroAux == null) {
			LivroNaoEncontradoException e = new LivroNaoEncontradoException(livro.getId());
			throw e;
		} else {
			livros.atualizar(livro);
			RepositorioLivrosArray.getInstance().salvarArquivo();
		}
	}

	public Livro consultar(int id) throws LivroNaoEncontradoException {
		Livro livro = livros.consultar(id);
		if (livro == null) {
			LivroNaoEncontradoException e = new LivroNaoEncontradoException(id);
			throw e;
		}
		return livro;
	}

	public ArrayList<Livro> listar() {
		return livros.listar();
	}
}
