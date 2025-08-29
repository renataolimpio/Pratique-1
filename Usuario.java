package br.com.sistemaeventos;

public class Usuario {
    private static int contador = 1;
    private int id;
    private String nome;
    private String email;
    private String cidade;
    private String estado;

    public Usuario(String nome, String email, String cidade, String estado) {
        this.id = contador++;
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " (" + email + ") - " + cidade + "/" + estado;
    }
}
