package Repositorio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Entidades.Aluno;

public class RepositorioAlunosArray implements RepositorioAlunos, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1690443057364996772L;

	private static RepositorioAlunosArray instance;
	private Aluno[] alunos;
	private int indice;

	private final static int TAMANHO = 200;

	private RepositorioAlunosArray() {
		alunos = new Aluno[TAMANHO];
		indice = 0;
	}

	public static RepositorioAlunosArray getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	private static RepositorioAlunosArray lerDoArquivo() {
		RepositorioAlunosArray instanciaLocal = null;
		File in = new File("alunos.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioAlunosArray) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioAlunosArray();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;
	}

	public void salvarArquivo() {
		if (instance == null) {
			return;
		}
		File out = new File("alunos.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					/* Silent */}
			}
		}
	}

	@Override
	public void cadastrar(Aluno aluno) {
		alunos[indice] = aluno;
		indice++;
	}

	@Override
	public void remover(String cpf) {
		for (int i = 0; i <= indice; i++) {
			if (alunos[i] != null) {
				if (alunos[i].getCpf().equals(cpf)) {
					alunos[i] = alunos[indice];
					alunos[indice] = null;
				}
			}
		}
	}

	@Override
	public void atualizar(Aluno aluno) {
		for (int i = 0; i <= indice; i++) {
			if (alunos[i] != null) {
				if (alunos[i].getCpf().equals(aluno.getCpf())) {
					alunos[i] = aluno;
				}
			}
		}
	}

	@Override
	public Aluno consultar(String cpf) {
		Aluno aluno = null;
		for (int i = 0; i <= indice; i++) {
			if (alunos[i] != null) {
				if (alunos[i].getCpf().equals(cpf)) {
					aluno = alunos[i];
				}
			}
		}
		return aluno;
	}

	@Override
	public ArrayList<Aluno> listar() {
		ArrayList<Aluno> aluno = new ArrayList<Aluno>();
		for (Aluno aln : alunos) {
			if (aln != null) {
				aluno.add(aln);
			}
		}
		return aluno;
	}
}
