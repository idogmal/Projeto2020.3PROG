package Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

import Repositorio.RepositorioEmprestimosArray;

public class Emprestimo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3068475570049101606L;
	private int id = 0;
	private static int contador = 0;
	private Aluno aluno;
	private Item itens[] = new Item[5];
	private Funcionario funcionario;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private boolean Devolvido;
	
	

	public Emprestimo( Aluno aluno, Item[] itens, Funcionario funcionario) {
		Emprestimo.contador = RepositorioEmprestimosArray.getInstance().listar().size()+1;
		this.id = contador;
		this.aluno = aluno;
		this.itens = itens;
		this.funcionario = funcionario;
		this.dataEmprestimo = LocalDate.now();
		this.dataDevolucao = dataEmprestimo.plusDays(15);
		this.setDevolvido(false);
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Item[] getItens() {
		return itens;
	}

	public void setItens(Item[] itens) {
		this.itens = itens;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDate getDataEmpretimo() {
		return dataEmprestimo;
	}

	public void setDataEmpretimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public static void setContador(int i) {
		Emprestimo.contador = i;
	}
	
	public int getId() {
		return id;
	}

	public boolean isDevolvido() {
		return Devolvido;
	}

	public void setDevolvido(boolean devolvido) {
		Devolvido = devolvido;
	}
	
	@Override
	public String toString() {
		return aluno.getNome() + " - " + dataEmprestimo + " - " + Arrays.toString(itens)
				+ ", " + funcionario.getNome();
	}
}
