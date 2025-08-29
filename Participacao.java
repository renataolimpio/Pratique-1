package br.com.sistemaeventos;

public class Participacao {
    private Usuario usuario;
    private Evento evento;

    public Participacao(Usuario usuario, Evento evento) {
        this.usuario = usuario;
        this.evento = evento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    @Override
    public String toString() {
        return usuario.getNome() + " está inscrito em: " + evento.getTitulo();
    }
}
