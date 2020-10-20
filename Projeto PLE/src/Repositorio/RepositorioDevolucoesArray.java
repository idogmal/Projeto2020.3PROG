package Repositorio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Entidades.Devolucao;

public class RepositorioDevolucoesArray implements RepositorioDevolucoes, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8470952087014330365L;
	private static RepositorioDevolucoesArray instance;
	private Devolucao[] devolucoes;
	private int indice;

	private final static int TAMANHO = 200;

	private RepositorioDevolucoesArray() {
		devolucoes = new Devolucao[TAMANHO];
		indice = 0;
	}

	public static RepositorioDevolucoesArray getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	private static RepositorioDevolucoesArray lerDoArquivo() {
		RepositorioDevolucoesArray instanciaLocal = null;
		File in = new File("devolucoes.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioDevolucoesArray) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioDevolucoesArray();
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
		File out = new File("devolucoes.dat");
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
	public void cadastrar(Devolucao devolucao) {
		devolucoes[indice] = devolucao;
		indice++;
	}

	@Override
	public void remover(int id) {
		for (int i = 0; i <= indice; i++) {
			if (devolucoes[i] != null) {
				if (devolucoes[i].getId() == id) {
					devolucoes[i] = devolucoes[indice];
					devolucoes[indice] = null;
				}
			}
		}
	}

	@Override
	public Devolucao consultar(int id) {
		Devolucao devolucao = null;
		for (int i = 0; i <= indice; i++) {
			if (devolucoes[i] != null) {
				if (devolucoes[i].getId() == id) {
					devolucao = devolucoes[i];
				}
			}
		}
		return devolucao;
	}

	@Override
	public ArrayList<Devolucao> procurarDevolucoes(String cpf) {
		ArrayList<Devolucao> devolucao = new ArrayList<Devolucao>();
		for (int i = 0; i <= indice; i++) {
			if (devolucoes[i] != null) {
				if (devolucoes[i].getAluno().getCpf().equals(cpf)) {
					devolucao.add(devolucoes[i]);
				}
			}
		}
		return devolucao;
	}

	@Override
	public ArrayList<Devolucao> listar() {
		RepositorioDevolucoesArray.getInstance();
		ArrayList<Devolucao> devolucao = new ArrayList<Devolucao>();
		for (Devolucao dvl : devolucoes) {
			if (dvl != null) {
				devolucao.add(dvl);
			}
		}
		return devolucao;
	}

}
