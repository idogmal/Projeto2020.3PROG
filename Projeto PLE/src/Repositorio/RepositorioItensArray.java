package Repositorio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Entidades.Item;

public class RepositorioItensArray implements RepositorioItens, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3503777212848115432L;
	private static RepositorioItensArray instance;
	private Item[] itens;
	private int indice;

	private final static int TAMANHO = 200;

	private RepositorioItensArray() {
		itens = new Item[TAMANHO];
		indice = 0;
	}

	public static RepositorioItensArray getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	private static RepositorioItensArray lerDoArquivo() {
		RepositorioItensArray instanciaLocal = null;
		File in = new File("itens.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioItensArray) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioItensArray();
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
		File out = new File("itens.dat");
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
	public void cadastrar(Item item) {
		itens[indice] = item;
		indice++;
	}

	@Override
	public void remover(int id) {
		for (int i = 0; i <= indice; i++) {
			if (itens[i] != null) {
				if (itens[i].getId() == id) {
					itens[i] = itens[indice];
					itens[indice] = null;
				}
			}
		}
	}

	@Override
	public Item consultar(int id) {
		Item item = null;
		for (int i = 0; i <= indice; i++) {
			if (itens[i] != null) {
				if (itens[i].getId() == id) {
					item = itens[i];
				}
			}
		}
		return item;
	}

}
