
package Entidades;


public class Livro {
    private int id = 0;
    private String titulo;
    private String autor;
    private int estoque;
    private int quantidade;  //correspondente a quantidade de livros emprestáveis
    
    public Livro(String titulo, String autor, int estoque, int id, int quantidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.estoque = estoque;
        this.id = id;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
}
