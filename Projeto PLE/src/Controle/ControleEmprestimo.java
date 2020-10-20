package Controle;

import java.util.ArrayList;

import Entidades.Emprestimo;
import Facade.exception.emprestimo.AlunoSemEmprestimoException;
import Facade.exception.emprestimo.EmprestimoJaExisteException;
import Facade.exception.emprestimo.EmprestimoNaoEncontradoException;
import Facade.exception.emprestimo.EmprestimoNuloException;
import Repositorio.RepositorioEmprestimos;
import Repositorio.RepositorioEmprestimosArray;

public class ControleEmprestimo {

	private RepositorioEmprestimos emprestimos;
	
	public ControleEmprestimo() {
		emprestimos = RepositorioEmprestimosArray.getInstance();
	}
	
	public void cadastrar(Emprestimo emprestimo) throws EmprestimoJaExisteException,EmprestimoNuloException{
		if(emprestimo.getAluno() != null && emprestimo.getFuncionario() != null && emprestimo.getItens() != null) {
			if(emprestimos.consultar(emprestimo.getId()) == null) {
				emprestimos.cadastrar(emprestimo);
				RepositorioEmprestimosArray.getInstance().salvarArquivo();
			}else {
				EmprestimoJaExisteException e = new EmprestimoJaExisteException(emprestimo.getId());
				throw e;
			}
		}else {
			EmprestimoNuloException e = new EmprestimoNuloException(emprestimo.getAluno(),emprestimo.getFuncionario(),emprestimo.getItens());
			throw e;
		}
	}
	
	public void remover(int id) throws EmprestimoNaoEncontradoException{
		Emprestimo emprestimo = emprestimos.consultar(id);
		if(emprestimo == null) {
			EmprestimoNaoEncontradoException e = new EmprestimoNaoEncontradoException(id);
			throw e;
		} else {
			emprestimos.remover(id);
			RepositorioEmprestimosArray.getInstance().salvarArquivo();
		}
	}
	
	public Emprestimo consultar(int id) throws EmprestimoNaoEncontradoException{
		Emprestimo emprestimo = emprestimos.consultar(id);
		if( emprestimo == null) {
			EmprestimoNaoEncontradoException e = new EmprestimoNaoEncontradoException(id);
			throw e;
		}
		return emprestimo;
	}
	
	public ArrayList<Emprestimo> procurarEmprestimos(String cpf) throws AlunoSemEmprestimoException{
		ArrayList<Emprestimo> emprestimo = emprestimos.procurarEmprestimos(cpf);
		if( emprestimo == null) {
			AlunoSemEmprestimoException e = new AlunoSemEmprestimoException(cpf);
			throw e;
		}
		return emprestimo;
	}
	
	public ArrayList<Emprestimo> Listar(){
		return emprestimos.listar();
	}
	
}
