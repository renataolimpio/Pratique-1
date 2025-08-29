package br.com.sistemaeventos;

public class Categoria {
    private static int contador = 1;
    private int id;
    private String nome;

    public Categoria(String nome) {
        this.id = contador++;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }
}

