package Exceptions.livro;

import Entidades.Livro;

public class LivroNaoEmprestavelException extends Exception {
    private Livro livro;

    public LivroNaoEmprestavelException(Livro livro) {
        super("Quantidade em estoque insuficiente para realizar o emprestimo!!!");
        this.livro = livro;
    }

    public Livro getLivro() {
        return livro;
    }

   
    
    
    
}
