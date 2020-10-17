package Repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Entidades.Livro;

public class RepositorioLivros implements RepositorioLivrosInterface, Serializable  {
	   
    private ArrayList<Livro> livros;
    private static RepositorioLivros instance;
    
    private RepositorioLivros(){
        this.livros = new ArrayList<>();
    }
    
    public static RepositorioLivros getInstance() {
		if (instance == null) {
			instance = lerArquivo();
		}
		return instance;
	}

	private static RepositorioLivros lerArquivo() {
		RepositorioLivros instancia = null;
		File in = new File("livros.txt");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instancia = (RepositorioLivros) o;
		} catch (Exception e) {
			instancia = new RepositorioLivros();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
				}
			}
		}

		return instancia;
	}

	public void salvarArquivo() {
		if (instance == null) {
			return;
		}
		File out = new File("livros.txt");
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
					}
			}
		}
	}
    
    
    @Override
    public void cadastrar(Livro livro){
        livros.add(livro);
    }
    
    @Override
    public void remover(int id){
        for(int i = 0; i<livros.size(); i++){
            if(livros!= null){
                if(livros.get(i).getId()== id){
                    livros.remove(i);
                }
            }
        }
    }
    
    @Override
    public Livro consultar(int id){
        Livro livro = null;
        for(int i = 0; i<livros.size(); i++){
            if(livros!= null){
                if(livros.get(i).getId()==id){
                    livro = livros.get(i);
                }
            }
        }
        return livro;
    }
    @Override
    public void atualizarEstoqueEmprestimo(Livro livro){
        for(int i = 0; i<livros.size(); i++){
            if(livros.get(i).getId()==livro.getId()){
                livros.get(i).setEstoque(livros.get(i).getEstoque() - livro.getQuantidade());
            }
        }
    }
    @Override
    public void atualizarEstoqueDevolucao(Livro livro){
        for(int i = 0; i<livros.size(); i++){
            if(livros.get(i).getId() == livro.getId()){
                livros.get(i).setEstoque(livros.get(i).getEstoque()+livro.getQuantidade());
            }
        }
    }
    
    public void atualizar(Livro livro){
        for(int i = 0; i<livros.size(); i++){
            if(livros.get(i)!=null){
                if(livros.get(i).getId()==livro.getId()){
                    livros.set(i, livro);
                }
            }
        }
    }

  
}
