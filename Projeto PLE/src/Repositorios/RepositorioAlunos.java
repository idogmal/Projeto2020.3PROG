package Repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Entidades.Aluno;

public class RepositorioAlunos implements RepositorioAlunosInterface, Serializable {
    
    private ArrayList<Aluno> alunos;
    private static RepositorioAlunos instance;

    private RepositorioAlunos() {
        alunos = new ArrayList<>();
    }

    public static RepositorioAlunos getInstance(){
        if(instance == null){
            instance = lerArquivo();
        }
        return instance;
    }
    
    
    
    public static RepositorioAlunos lerArquivo() {
        RepositorioAlunos instancia = null;
        File in = new File("alunos.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
        fis = new FileInputStream(in);
      
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instancia = (RepositorioAlunos) o;
        } catch (Exception e) {
            instancia = new RepositorioAlunos();
          
        }
        finally{
            if(ois != null){
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
					
        }
      }
     }
   }
    
    @Override
    public void cadastrar(Aluno aluno){
       
        alunos.add(aluno);
    }
    
    @Override
    public void remover(String cpf){
        
        for(int i = 0; i<alunos.size(); i++){
            if(alunos.get(i)!=null){
                alunos.get(i).getCpf().equals(cpf);
                alunos.remove(i);
            }
        
        }
    }
    
    @Override
    public void atualizar(Aluno aluno){
        for(int i = 0; i<alunos.size();i++){
            if(alunos.get(i)!=null){
                if(alunos.get(i).getCpf().equals(aluno.getCpf())){
                    alunos.set(i, aluno);
                    
                }
            }
        }
    }
    
    @Override
    public Aluno consultar(String cpf){
        Aluno aluno = null;
        for(int i = 0; i<alunos.size();i++){
            if(alunos.get(i)!=null){
                if(alunos.get(i).getCpf().equals(cpf)){
                    aluno = alunos.get(i);
                }
            }
        }
            return aluno;
    }
       
}
