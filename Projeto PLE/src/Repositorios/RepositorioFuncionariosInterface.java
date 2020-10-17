package Repositorios;

	import Entidades.Funcionario;


	public interface RepositorioFuncionariosInterface {
	    void cadastrar(Funcionario funcionario);
	    void remover(String cpf);
	    void atualizar(Funcionario funcionario);
	    Funcionario consultar(String cpf);
	    boolean validarFuncionario(String cpf, String senha);
	}


