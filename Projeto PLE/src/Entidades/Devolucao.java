package Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

import Repositorio.RepositorioDevolucoesArray;

public class Devolucao implements Serializable {

	@Override
	public String toString() {
		return "" + aluno.getNome() + ", " + dataDevolucao + ", " + funcionario.getNome() + ", livros:"
				+ Arrays.toString(itens) + "]";
	}

	/**
	 * Arrays.toString(itens)
	 * 
	 */
	private static final long serialVersionUID = 5897811956750760212L;
	private int id = 0;
	private static int contador = 0;
	private Aluno aluno;
	private Item[] itens;
	private Funcionario funcionario;
	private LocalDate dataDevolucao;
	private float multa;

	public Devolucao(Aluno aluno, Item[] itens, Funcionario funcionario) {
		Devolucao.contador = RepositorioDevolucoesArray.getInstance().listar().size() + 1;
		this.aluno = aluno;
		this.itens = itens;
		this.funcionario = funcionario;
		this.dataDevolucao = LocalDate.now();
		this.multa = 0;
		this.id = contador;

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

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public int getId() {
		return id;
	}

	public static int getContador() {
		return contador;
	}

	public float getMulta() {
		return multa;
	}

	public void setMulta(float multa) {
		this.multa = multa;
	}

	public static void setContador(int i) {
		Devolucao.contador = i;
	}

}
