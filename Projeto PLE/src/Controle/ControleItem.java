package Controle;

import Entidades.Item;
import Facade.exception.item.ItemNaoEncontradoException;
import Facade.exception.item.ItemNuloException;
import Repositorio.RepositorioItens;
import Repositorio.RepositorioItensArray;

public class ControleItem {

	private RepositorioItens itens;

	public ControleItem() {
		itens = RepositorioItensArray.getInstance();
	}

	public void cadastrar(Item item) throws ItemNuloException {
		if (item.getLivro() != null && item.getQuantidade() >= 1) {
			itens.cadastrar(item);
			RepositorioItensArray.getInstance().salvarArquivo();
		} else {
			ItemNuloException e = new ItemNuloException(item.getLivro(), item.getQuantidade());
			throw e;
		}
	}

	public void remover(int id) throws ItemNaoEncontradoException {
		Item item = itens.consultar(id);
		if (item == null) {
			ItemNaoEncontradoException e = new ItemNaoEncontradoException(id);
			throw e;
		} else {
			itens.remover(id);
			RepositorioItensArray.getInstance().salvarArquivo();
		}
	}

	public Item consultar(int id) throws ItemNaoEncontradoException {
		Item item = itens.consultar(id);
		if (item == null) {
			ItemNaoEncontradoException e = new ItemNaoEncontradoException(id);
			throw e;
		}
		return item;
	}

}
