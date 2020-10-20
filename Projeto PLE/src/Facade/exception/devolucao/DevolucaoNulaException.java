package Facade.exception.devolucao;

import Entidades.Aluno;
import Entidades.Funcionario;
import Entidades.Item;

public class DevolucaoNulaException extends Exception {

	private Aluno aluno;
	private Item[] itens;
	private Funcionario funcionario;

	public DevolucaoNulaException(Aluno aluno, Item[] itens, Funcionario funcionario) {
		super("Aluno, Itens e/ou Funcionario nulos!");
		this.aluno = aluno;
		this.itens = itens;
		this.funcionario = funcionario;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public Item[] getItens() {
		return itens;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

}
