package Repositorio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Entidades.Funcionario;

public class RepositorioFuncionariosArray implements RepositorioFuncionarios, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1649975251449009777L;
	private static RepositorioFuncionariosArray instance;
	private Funcionario[] funcionarios;
	private int indice;

	private final static int TAMANHO = 200;

	private RepositorioFuncionariosArray() {
		funcionarios = new Funcionario[TAMANHO];
		indice = 0;
	}

	public static RepositorioFuncionariosArray getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	private static RepositorioFuncionariosArray lerDoArquivo() {
		RepositorioFuncionariosArray instanciaLocal = null;
		File in = new File("funcionarios.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioFuncionariosArray) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioFuncionariosArray();
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
		File out = new File("funcionarios.dat");
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
	public void cadastrar(Funcionario funcionario) {
		funcionarios[indice] = funcionario;
		indice++;
	}

	@Override
	public void remover(String cpf) {
		for (int i = 0; i <= indice; i++) {
			if (funcionarios[i] != null) {
				if (funcionarios[i].getCpf().equals(cpf)) {
					funcionarios[i] = funcionarios[indice];
					funcionarios[indice] = null;
				}
			}
		}
	}

	@Override
	public void atualizar(Funcionario funcionario) {
		for (int i = 0; i <= indice; i++) {
			if (funcionarios[i] != null) {
				if (funcionarios[i].getCpf().equals(funcionario.getCpf())) {
					funcionarios[i] = funcionario;
				}
			}
		}
	}

	@Override
	public Funcionario consultar(String cpf) {
		Funcionario funcionario = null;
		for (int i = 0; i <= indice; i++) {
			if (funcionarios[i] != null) {
				if (funcionarios[i].getCpf().equals(cpf)) {
					funcionario = funcionarios[i];
				}
			}
		}
		return funcionario;
	}

	@Override
	public ArrayList<Funcionario> listar() {
		ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();
		for (Funcionario fcn : funcionarios) {
			if (fcn != null) {
				funcionario.add(fcn);
			}
		}
		return funcionario;
	}

	@Override
	public boolean validarFuncionario(String cpf, String senha) {
		boolean retorno = false;
		for (int i = 0; i <= indice; i++) {
			if (funcionarios[i] != null) {
				if (funcionarios[i].getCpf().equals(cpf) && funcionarios[i].getSenha().equals(senha)) {
					retorno = true;
				}
			}
		}
		return retorno;
	}

}
