package Facade.exception.emprestimo;

public class EmprestimoJaExisteException extends Exception {

	private int id;

	public EmprestimoJaExisteException(int id) {
		super("Empréstimo já exitente!");
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
