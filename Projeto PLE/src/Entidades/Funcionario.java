
package Entidades;


public class Funcionario extends Pessoa {
    private String senha;

    public Funcionario(String nome, String cpf, String senha) {
        super(nome,cpf);
        this.senha = senha;
    }
    
    public String getCpf() {
		return super.getCpf();
	}
	
	public void setCpf(String cpf) {
		super.setCpf(cpf);
	}
	
	public String getNome() {
		return super.getNome();
	}
	
	public void setNome(String nome) {
		super.setNome(nome);
	}

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
        
        
}
