package Repositorio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Entidades.Emprestimo;

public class RepositorioEmprestimosArray implements RepositorioEmprestimos, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1080911171862270419L;
	private static RepositorioEmprestimosArray instance;
	private Emprestimo[] emprestimos;
	private int indice;

	private final static int TAMANHO = 200;

	private RepositorioEmprestimosArray() {
		emprestimos = new Emprestimo[TAMANHO];
		indice = 0;
	}

	public static RepositorioEmprestimosArray getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	private static RepositorioEmprestimosArray lerDoArquivo() {
		RepositorioEmprestimosArray instanciaLocal = null;
		File in = new File("emprestimos.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioEmprestimosArray) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioEmprestimosArray();
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
		File out = new File("emprestimos.dat");
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
	public void cadastrar(Emprestimo emprestimo) {
		emprestimos[indice] = emprestimo;
		indice++;
	}

	@Override
	public void remover(int id) {
		for (int i = 0; i <= indice; i++) {
			if (emprestimos[i] != null) {
				if (emprestimos[i].getId() == id) {
					emprestimos[i] = emprestimos[indice];
					emprestimos[indice] = null;
				}
			}
		}
	}

	@Override
	public Emprestimo consultar(int id) {
		Emprestimo emprestimo = null;
		for (int i = 0; i <= indice; i++) {
			if (emprestimos[i] != null) {
				if (emprestimos[i].getId() == id) {
					emprestimo = emprestimos[i];
				}
			}
		}
		return emprestimo;
	}

	public ArrayList<Emprestimo> procurarEmprestimos(String cpf) {
		ArrayList<Emprestimo> emprestimo = new ArrayList<Emprestimo>();
		for (int i = 0; i <= indice; i++) {
			if (emprestimos[i] != null) {
				if (emprestimos[i].getAluno().getCpf().equals(cpf)) {
					if (emprestimos[i].isDevolvido() == false) {
						emprestimo.add(emprestimos[i]);
					}
				}
			}
		}
		return emprestimo;
	}

	@Override
	public ArrayList<Emprestimo> listar() {
		lerDoArquivo();
		ArrayList<Emprestimo> emprestimo = new ArrayList<Emprestimo>();
		for (Emprestimo emp : emprestimos) {
			if (emp != null) {
				emprestimo.add(emp);
			}
		}
		return emprestimo;
	}

}
