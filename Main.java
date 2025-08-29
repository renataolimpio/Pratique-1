package br.com.sistemaeventos;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaEventos sistema = new SistemaEventos();

        // Criando categorias padrão
        sistema.cadastrarCategoria("Show");
        sistema.cadastrarCategoria("Esportivo");
        sistema.cadastrarCategoria("Tecnologia");
        sistema.cadastrarCategoria("Acadêmico");
        sistema.cadastrarCategoria("Religioso");
        sistema.cadastrarCategoria("Festival");
        sistema.cadastrarCategoria("Cinema");
        sistema.cadastrarCategoria("Feira");
        sistema.cadastrarCategoria("Workshop");
        sistema.cadastrarCategoria("Outro");

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Cadastrar evento");
            System.out.println("4 - Listar eventos");
            System.out.println("5 - Inscrever usuário em evento");
            System.out.println("6 - Cancelar inscrição");
            System.out.println("7 - Listar participações");
            System.out.println("8 - Listar eventos futuros");
            System.out.println("9 - Listar eventos passados");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = sc.nextLine();
                    System.out.print("Estado: ");
                    String estado = sc.nextLine();

                    sistema.cadastrarUsuario(nome, email, cidade, estado);
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 2:
                    sistema.listarUsuarios();
                    break;

                case 3:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();

                    System.out.println("Categorias disponíveis:");
                    sistema.listarCategorias();

                    System.out.print("Escolha o ID da categoria: ");
                    int catId = Integer.parseInt(sc.nextLine());
                    Categoria cat = sistema.buscarCategoriaPorId(catId);

                    if (cat == null) {
                        System.out.println("Categoria não encontrada. Usando 'Outro'.");
                        cat = new Categoria("Outro");
                    }

                    // Se for "Outro", cria nova categoria
                    if (cat.getNome().equalsIgnoreCase("Outro")) {
                        System.out.print("Digite o nome da nova categoria: ");
                        String novaCat = sc.nextLine();
                        sistema.cadastrarCategoria(novaCat);
                        cat = sistema.getCategorias().get(sistema.getCategorias().size() - 1);
                    }

                    System.out.print("Data e hora (yyyy-MM-dd HH:mm): ");
                    LocalDateTime dataHora = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                    sistema.cadastrarEvento(titulo, desc, dataHora, cat);
                    System.out.println("Evento cadastrado com sucesso!");
                    break;

                case 4:
                    sistema.listarEventos();
                    break;

                case 5:
                    sistema.listarUsuarios();
                    System.out.print("Digite o ID do usuário: ");
                    int userId = Integer.parseInt(sc.nextLine());
                    Usuario u = sistema.buscarUsuarioPorId(userId);

                    sistema.listarEventos();
                    System.out.print("Digite o ID do evento: ");
                    int eventId = Integer.parseInt(sc.nextLine());
                    Evento e = sistema.buscarEventoPorId(eventId);

                    if (u != null && e != null) {
                        sistema.inscreverUsuarioEvento(u, e);
                    } else {
                        System.out.println("Usuário ou evento não encontrado!");
                    }
                    break;

                case 6:
                    System.out.println("Função de cancelar inscrição ainda simplificada.");
                    break;

                case 7:
                    sistema.listarParticipacoes();
                    break;

                case 8:
                    sistema.listarEventosFuturos();
                    break;

                case 9:
                    sistema.listarEventosPassados();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
