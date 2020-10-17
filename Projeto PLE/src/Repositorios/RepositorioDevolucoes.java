package Repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Entidades.Devolucao;

public class RepositorioDevolucoes implements RepositorioDevolucoesInterface, Serializable{

	 
	   
    private ArrayList<Devolucao> devolucoes;
    private static RepositorioDevolucoes instance;

    private RepositorioDevolucoes() {
        this.devolucoes = new ArrayList<>();
    }
    public static RepositorioDevolucoes getInstance() {
		if (instance == null) {
			instance = lerArquivo();
		}
		return instance;
	}

	private static RepositorioDevolucoes lerArquivo() {
		RepositorioDevolucoes instancia = null;
		File in = new File("devolucoes.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
		    fis = new FileInputStream(in);
		    ois = new ObjectInputStream(fis);
		    Object o = ois.readObject();
		    instancia = (RepositorioDevolucoes) o;
		} catch (Exception e) {
			instancia = new RepositorioDevolucoes();
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
		File out = new File("devolucoes.txt");
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
     public void cadastrar(Devolucao devolucao){
         devolucoes.add(devolucao);
     }
     
    @Override
     public void remover(int id){
         for(int i = 0; i<devolucoes.size(); i++){
             if(devolucoes.get(i)!=null){
              if(devolucoes.get(i).getId() == id){
                 devolucoes.remove(i);
              }       
                 
             }
         }
       
     }
     
    @Override
     public Devolucao consultar(int id){
         Devolucao devolucao = null;
         
         for(int i = 0 ; i<devolucoes.size(); i++){
             if(devolucoes!=null){
                 if(devolucoes.get(i).getId()==id){
                     devolucao = devolucoes.get(i);
                 }
             }
         }
            return devolucao;
     }
     
}
