package Repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Entidades.Emprestimo;

public class RepositorioEmprestimos implements RepositorioEmprestimosInterface, Serializable {
    
    private ArrayList<Emprestimo> emprestimos;
    private RepositorioEmprestimos instance;
    
    private RepositorioEmprestimos() {
        this.emprestimos = new ArrayList<>();
    }
    
  private static RepositorioEmprestimos lerArquivo() {
      
		RepositorioEmprestimos instancia = null;
		File in = new File("emprestimos.txt");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instancia = (RepositorioEmprestimos) o;
		} catch (Exception e) {
			instancia = new RepositorioEmprestimos();
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
			}
			}
		}
	}

    
    @Override
    public void cadastrar(Emprestimo emprestimo){
       emprestimos.add(emprestimo);
    }
    
    @Override
    public void remover(int id){
        for(int i =0; i<emprestimos.size(); i++){
            if(emprestimos!=null){
                if(emprestimos.get(i).getId()==id){
                    emprestimos.remove(i);
                }
            }
        }
    }
    @Override
    public Emprestimo consultar(int id){
        Emprestimo emprestimo = null;
        for(int i = 0; i<emprestimos.size(); i++){
            if(emprestimos!=null){
            if(emprestimos.get(i).getId()==id){
                emprestimo = emprestimos.get(i);
                
            }
        }
        }
        return emprestimo;
    }
    
    
}
