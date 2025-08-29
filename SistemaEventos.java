package br.com.sistemaeventos;

import java.util.*;
import java.time.*;

public class SistemaEventos {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();
    private List<Categoria> categorias = new ArrayList<>();
    private List<Participacao> participacoes = new ArrayList<>();

    // -------- USUÁRIOS --------
    public void cadastrarUsuario(String nome, String email, String cidade, String estado) {
        usuarios.add(new Usuario(nome, email, cidade, estado));
    }

    public void listarUsuarios() {
        usuarios.forEach(System.out::println);
    }

    public Usuario buscarUsuarioPorId(int id) {
        return usuarios.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    // -------- CATEGORIAS --------
    public void cadastrarCategoria(String nome) {
        categorias.add(new Categoria(nome));
    }

    public void listarCategorias() {
        categorias.forEach(System.out::println);
    }

    public Categoria buscarCategoriaPorId(int id) {
        return categorias.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    // -------- EVENTOS --------
    public void cadastrarEvento(String titulo, String descricao, LocalDateTime dataHora, Categoria categoria) {
        eventos.add(new Evento(titulo, descricao, dataHora, categoria));
    }

    public void listarEventos() {
        eventos.stream()
                .sorted(Comparator.comparing(Evento::getDataHora))
                .forEach(System.out::println);
    }

    public Evento buscarEventoPorId(int id) {
        return eventos.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public void listarEventosFuturos() {
        LocalDateTime agora = LocalDateTime.now();
        eventos.stream()
                .filter(e -> e.getDataHora().isAfter(agora))
                .sorted(Comparator.comparing(Evento::getDataHora))
                .forEach(System.out::println);
    }

    public void listarEventosPassados() {
        LocalDateTime agora = LocalDateTime.now();
        eventos.stream()
                .filter(e -> e.getDataHora().isBefore(agora))
                .sorted(Comparator.comparing(Evento::getDataHora))
                .forEach(System.out::println);
    }

    // -------- PARTICIPAÇÕES --------
    public void inscreverUsuarioEvento(Usuario u, Evento e) {
        boolean jaInscrito = participacoes.stream()
                .anyMatch(p -> p.getUsuario().equals(u) && p.getEvento().equals(e));
        if (!jaInscrito) {
            participacoes.add(new Participacao(u, e));
            System.out.println("Usuário inscrito no evento com sucesso!");
        } else {
            System.out.println("Usuário já está inscrito neste evento!");
        }
    }

    public void cancelarInscricao(Usuario u, Evento e) {
        boolean removido = participacoes.removeIf(p -> p.getUsuario().equals(u) && p.getEvento().equals(e));
        if (removido) {
            System.out.println("Inscrição cancelada com sucesso!");
        } else {
            System.out.println("Inscrição não encontrada!");
        }
    }

    public void listarParticipacoes() {
        participacoes.forEach(System.out::println);
    }
}
