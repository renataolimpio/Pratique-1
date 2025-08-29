package br.com.sistemaeventos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
    private static int contador = 1;
    private int id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataHora;
    private Categoria categoria;

    public Evento(String titulo, String descricao, LocalDateTime dataHora, Categoria categoria) {
        this.id = contador++;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return id + " - " + titulo + " | " + descricao + " | " + categoria.getNome() + " | " + dataHora.format(fmt);
    }
}

