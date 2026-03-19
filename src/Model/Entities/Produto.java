package Model.Entities;

public class Produto {
    private Long id;
    private String nome;
    private double preco;

    public Produto() {
        this.id = (long) Core.IDGenerator.getNextId();
    }

    public Produto(Long id, String nome, double preco) {
        this.id = (id != null) ? id : (long) Core.IDGenerator.getNextId();
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
