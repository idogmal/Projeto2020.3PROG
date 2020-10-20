package Controle;

import java.time.Duration;
import java.util.ArrayList;

import Entidades.Devolucao;
import Entidades.Emprestimo;
import Facade.exception.devolucao.AlunoSemDevolucaoException;
import Facade.exception.devolucao.DevolucaoJaExisteException;
import Facade.exception.devolucao.DevolucaoNaoEncontradaException;
import Facade.exception.devolucao.DevolucaoNulaException;
import Repositorio.RepositorioDevolucoes;
import Repositorio.RepositorioDevolucoesArray;

public class ControleDevolucao {

	private RepositorioDevolucoes devolucoes;

	public ControleDevolucao() {
		devolucoes = RepositorioDevolucoesArray.getInstance();
	}

	public void cadastrar(Devolucao devolucao) throws DevolucaoJaExisteException, DevolucaoNulaException {
		if (devolucao.getAluno() != null && devolucao.getFuncionario() != null && devolucao.getItens() != null) {
			if (devolucoes.consultar(devolucao.getId()) == null) {
				devolucoes.cadastrar(devolucao);
				RepositorioDevolucoesArray.getInstance().salvarArquivo();
			} else {
				DevolucaoJaExisteException e = new DevolucaoJaExisteException(devolucao.getId());
				throw e;
			}
		} else {
			DevolucaoNulaException e = new DevolucaoNulaException(devolucao.getAluno(), devolucao.getItens(),
					devolucao.getFuncionario());
			throw e;
		}
	}

	public float devolver(Emprestimo emprestimo, Devolucao devolucao) {
		float multa = 0;
		emprestimo.setDevolvido(true);
		if (devolucao.getDataDevolucao().isAfter(emprestimo.getDataDevolucao())) {
			multa = (float) (3.50 * Duration
					.between(emprestimo.getDataDevolucao().atStartOfDay(), devolucao.getDataDevolucao().atStartOfDay())
					.toDays());
			devolucao.setMulta(multa);
		}
		return multa;
	}

	public void remover(int id) throws DevolucaoNaoEncontradaException {
		Devolucao devolucao = devolucoes.consultar(id);
		if (devolucao == null) {
			DevolucaoNaoEncontradaException e = new DevolucaoNaoEncontradaException(id);
			throw e;
		} else {
			devolucoes.remover(id);
			RepositorioDevolucoesArray.getInstance().salvarArquivo();
		}
	}

	public Devolucao consultar(int id) throws DevolucaoNaoEncontradaException {
		Devolucao devolucao = devolucoes.consultar(id);
		if (devolucao == null) {
			DevolucaoNaoEncontradaException e = new DevolucaoNaoEncontradaException(id);
			throw e;
		}
		return devolucao;
	}

	public ArrayList<Devolucao> procurarDevolucoes(String cpf) throws AlunoSemDevolucaoException {
		ArrayList<Devolucao> devolucao = devolucoes.procurarDevolucoes(cpf);
		if (devolucao == null) {
			AlunoSemDevolucaoException e = new AlunoSemDevolucaoException(cpf);
			throw e;
		}
		return devolucao;
	}

	public ArrayList<Devolucao> listar() {
		return devolucoes.listar();
	}

}
