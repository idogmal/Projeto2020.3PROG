package Facade;

import java.util.ArrayList;

import Controle.ControleAluno;
import Controle.ControleDevolucao;
import Controle.ControleEmprestimo;
import Controle.ControleFuncionario;
import Controle.ControleItem;
import Controle.ControleLivro;
import Entidades.Aluno;
import Entidades.Devolucao;
import Entidades.Emprestimo;
import Entidades.Funcionario;
import Entidades.Item;
import Entidades.Livro;
import Facade.exception.aluno.AlunoNaoEncontradoException;
import Facade.exception.aluno.AlunoNuloException;
import Facade.exception.aluno.CpfJaExisteException;
import Facade.exception.devolucao.AlunoSemDevolucaoException;
import Facade.exception.devolucao.DevolucaoJaExisteException;
import Facade.exception.devolucao.DevolucaoNaoEncontradaException;
import Facade.exception.devolucao.DevolucaoNulaException;
import Facade.exception.emprestimo.AlunoSemEmprestimoException;
import Facade.exception.emprestimo.EmprestimoJaExisteException;
import Facade.exception.emprestimo.EmprestimoNaoEncontradoException;
import Facade.exception.emprestimo.EmprestimoNuloException;
import Facade.exception.funcionario.FuncionarioNaoEncontradoException;
import Facade.exception.funcionario.FuncionarioNuloException;
import Facade.exception.item.ItemNaoEncontradoException;
import Facade.exception.item.ItemNuloException;
import Facade.exception.livro.LivroJaExisteException;
import Facade.exception.livro.LivroNaoEmprestavelException;
import Facade.exception.livro.LivroNaoEncontradoException;
import Facade.exception.livro.LivroNuloException;

public class Fachada {

	private ControleAluno alunos;
	private ControleDevolucao devolucoes;
	private ControleEmprestimo emprestimos;
	private ControleFuncionario funcionarios;
	private ControleItem itens;
	private ControleLivro livros;

	private static Fachada instance;

	private Fachada() {
		alunos = new ControleAluno();
		devolucoes = new ControleDevolucao();
		emprestimos = new ControleEmprestimo();
		funcionarios = new ControleFuncionario();
		itens = new ControleItem();
		livros = new ControleLivro();
	}

	public static Fachada getInstance() {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return instance;
	}


	public void cadastrar(Aluno aluno) throws CpfJaExisteException, AlunoNuloException {
		alunos.cadastrar(aluno);
	}

	public void remover(String cpf) throws AlunoNaoEncontradoException {
		alunos.remover(cpf);
	}

	public void atualizar(Aluno aluno) throws AlunoNaoEncontradoException {
		alunos.atualizar(aluno);
	}

	public Aluno consultar(String cpf) throws AlunoNaoEncontradoException {
		return alunos.consultar(cpf);
	}

	public ArrayList<Aluno> listar() {
		return alunos.listar();
	}

	
	public void cadastrar(Devolucao devolucao) throws DevolucaoJaExisteException, DevolucaoNulaException {
		devolucoes.cadastrar(devolucao);
	}

	public float devolver(Emprestimo emprestimo, Devolucao devolucao) {
		return devolucoes.devolver(emprestimo, devolucao);
	}

	public void removerDevolucao(int id) throws DevolucaoNaoEncontradaException {
		devolucoes.remover(id);
	}

	public Devolucao consultarDevolucao(int id) throws DevolucaoNaoEncontradaException {
		return devolucoes.consultar(id);
	}

	public ArrayList<Devolucao> procurarDevolucoes(String cpf) throws AlunoSemDevolucaoException {
		return devolucoes.procurarDevolucoes(cpf);
	}

	public ArrayList<Devolucao> listarDevolucao() {
		return devolucoes.listar();
	}

	
	public void cadastrar(Emprestimo emprestimo) throws EmprestimoJaExisteException, EmprestimoNuloException {
		emprestimos.cadastrar(emprestimo);
	}

	public void removerEmprestimo(int id) throws EmprestimoNaoEncontradoException {
		emprestimos.remover(id);
	}

	public Emprestimo consultarEmprestimo(int id) throws EmprestimoNaoEncontradoException {
		return emprestimos.consultar(id);
	}

	public ArrayList<Emprestimo> listarEmprestimos() {
		return emprestimos.Listar();
	}

	public ArrayList<Emprestimo> procurarEmprestimos(String cpf) throws AlunoSemEmprestimoException {
		return emprestimos.procurarEmprestimos(cpf);
	}

	
	public void cadastrar(Funcionario funcionario) throws CpfJaExisteException, FuncionarioNuloException {
		funcionarios.cadastrar(funcionario);
	}

	public void removerFuncionario(String cpf) throws FuncionarioNaoEncontradoException {
		funcionarios.remover(cpf);
	}

	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		funcionarios.atualizar(funcionario);
	}

	public Funcionario consultarFuncionario(String cpf) throws FuncionarioNaoEncontradoException {
		return funcionarios.consultar(cpf);
	}

	public ArrayList<Funcionario> listarFuncionarios() {
		return funcionarios.listar();
	}

	public boolean validarFuncionario(String cpf, String senha) throws FuncionarioNaoEncontradoException {
		return funcionarios.validarFuncionario(cpf, senha);
	}

	
	public void cadastrar(Item item) throws ItemNuloException {
		itens.cadastrar(item);
	}

	public void removerItem(int id) throws ItemNaoEncontradoException {
		itens.remover(id);
	}

	public Item consultarItem(int id) throws ItemNaoEncontradoException {
		return itens.consultar(id);
	}

	

	public void cadastrar(Livro livro) throws LivroJaExisteException, LivroNuloException {
		livros.cadastrar(livro);
	}

	public void removerLivros(int id) throws LivroNaoEncontradoException {
		livros.remover(id);
	}

	public void atualizar(Livro livro) throws LivroNaoEncontradoException {
		livros.atualizar(livro);
	}

	public Livro consultarLivro(int id) throws LivroNaoEncontradoException {
		return livros.consultar(id);
	}

	public void atualizarEstoqueEmprestimo(Emprestimo emprestimo) {
		livros.atualizarEstoqueEmprestimo(emprestimo);
	}

	public void atualizarEstoqueDevolucao(Devolucao devolucao) {
		livros.atualizarEstoqueDevolucao(devolucao);
	}

	public ArrayList<Livro> listarLivros() {
		return livros.listar();
	}

	public boolean consultarEstoque(Item item) throws LivroNaoEmprestavelException {
		return livros.consultarEstoque(item);
	}

}
