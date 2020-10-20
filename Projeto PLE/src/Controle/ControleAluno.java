package Controle;

import java.util.ArrayList;

import Entidades.Aluno;
import Facade.exception.aluno.AlunoNaoEncontradoException;
import Facade.exception.aluno.AlunoNuloException;
import Facade.exception.aluno.CpfJaExisteException;
import Repositorio.RepositorioAlunos;
import Repositorio.RepositorioAlunosArray;

public class ControleAluno {

	private RepositorioAlunos alunos;

	public ControleAluno() {
		alunos = RepositorioAlunosArray.getInstance();
	}

	public void cadastrar(Aluno aluno) throws CpfJaExisteException, AlunoNuloException {
		if (aluno.getNome() != null && aluno.getCpf().length() == 11) {
			if (alunos.consultar(aluno.getCpf()) == null) {
				alunos.cadastrar(aluno);
				RepositorioAlunosArray.getInstance().salvarArquivo();
			} else {
				CpfJaExisteException e = new CpfJaExisteException(aluno.getCpf());
				throw e;
			}
		} else {
			AlunoNuloException e = new AlunoNuloException(aluno.getNome(), aluno.getCpf());
			throw e;
		}
	}

	public void remover(String cpf) throws AlunoNaoEncontradoException {
		Aluno aluno = alunos.consultar(cpf);
		if (aluno == null) {
			AlunoNaoEncontradoException e = new AlunoNaoEncontradoException(cpf);
			throw e;
		} else {
			alunos.remover(cpf);
			RepositorioAlunosArray.getInstance().salvarArquivo();
		}
	}

	public void atualizar(Aluno aluno) throws AlunoNaoEncontradoException {
		Aluno alunoAux = alunos.consultar(aluno.getCpf());
		if (aluno == null || alunoAux == null) {
			AlunoNaoEncontradoException e = new AlunoNaoEncontradoException(aluno.getCpf());
			throw e;
		} else {
			alunos.atualizar(aluno);
			RepositorioAlunosArray.getInstance().salvarArquivo();
		}
	}

	public Aluno consultar(String cpf) throws AlunoNaoEncontradoException {
		Aluno aluno = alunos.consultar(cpf);
		if (aluno == null) {
			AlunoNaoEncontradoException e = new AlunoNaoEncontradoException(cpf);
			throw e;
		}
		return aluno;
	}

	public ArrayList<Aluno> listar() {
		return alunos.listar();
	}
}
