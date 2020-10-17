package Repositorios;

	import Entidades.Devolucao;

	public interface RepositorioDevolucoesInterface {
	    void cadastrar(Devolucao devolucao);
	    void remover(int id);
	    Devolucao consultar(int id);
	}

