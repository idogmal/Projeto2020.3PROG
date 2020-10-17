package Repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Entidades.Funcionario;

public class RepositorioFuncionarios implements RepositorioFuncionariosInterface, Serializable {
	   
    private ArrayList<Funcionario> funcionarios;
    private static RepositorioFuncionarios instance;
    
    public RepositorioFuncionarios() {
        this.funcionarios = funcionarios;
    }
    
    	public static RepositorioFuncionarios getInstance() {
		if (instance == null) {
			instance = lerArquivo();
		}
		return instance;
	}

	private static RepositorioFuncionarios lerArquivo() {
		RepositorioFuncionarios instancia = null;
		File in = new File("funcionarios.txt");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instancia = (RepositorioFuncionarios) o;
		} catch (Exception e) {
			instancia = new RepositorioFuncionarios();
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
		File out = new File("funcionarios.txt");
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
  public void cadastrar(Funcionario funcionario){
      funcionarios.add(funcionario);
  }    
  
    @Override
  public void remover(String cpf){
      for(int i = 0; i<funcionarios.size(); i++){
          if(funcionarios!=null){
             if(funcionarios.get(i).getCpf().equals(cpf)){
                 funcionarios.remove(i);
             }
          }
      }
  }
    @Override
  public void atualizar(Funcionario funcionario){
      for(int i = 0; i<funcionarios.size(); i++){
          if(funcionarios!=null){
              if(funcionarios.get(i).getCpf().equals(funcionario.getCpf())){
                 funcionarios.set(i, funcionario);
              }
          }
      }
  }
    @Override
  public Funcionario consultar(String cpf){
      Funcionario funcionario = null;
      for(int i = 0; i<funcionarios.size(); i++){
          if(funcionarios!= null){
              if(funcionarios.get(i).getCpf().equals(cpf)){
                  funcionario = funcionarios.get(i);
              }
          }
      }
      return funcionario;
  }
  
    @Override
  public boolean validarFuncionario(String cpf, String senha){
      boolean resultado = false;
      for(int i = 0; i<funcionarios.size(); i++){
          if(funcionarios.get(i)!=null){
          if(funcionarios.get(i).getCpf().equals(cpf) && funcionarios.get(i).getSenha().equals(senha)){
              resultado = true;
          }
      }
    }
      return resultado;
  }
}
