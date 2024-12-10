package br.com.fatecmogidascruzes.view;

import java.time.LocalDate;
import java.util.Scanner;

import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.entity.Livro;
import br.com.fatecmogidascruzes.model.entity.Pedido;
import br.com.fatecmogidascruzes.service.impl.*;

public class ClienteView {
    PedidoServiceImpl pedidoService = new PedidoServiceImpl();
    LivroServiceImpl livroService = new LivroServiceImpl();
    Scanner scanner = new Scanner(System.in);

    public void comprarLivro(Cliente cliente){
    
        System.out.println("Digite o titulo do livro que você deseja comprar:");
        String valorBuscar = scanner.nextLine();

        Livro livro = livroService.comprarByTitulo(valorBuscar);

        System.out.println("----- Confira o livro pedido: -----");
        System.out.println(livroService.buscarLivro(3,valorBuscar));

        System.out.println("----- Confirmar compra? -----\n1 - Sim\n2 - Não");
        int opcao = Integer.parseInt(scanner.next());

        if(opcao == 1){
            pedidoService.adicionarPedido(new Pedido(cliente.getEmail(), livro.getTitulo(), LocalDate.now(), 1, livro.getPreco(), cliente.getEndereco()));
        }else{
            System.out.println("Compra cancelada.");
        }
    }

    public void buscarLivro() {
        int opcao;
        String valorBuscar = "";

        do {
            System.out.println(mensagemBuscar());
            opcao = scanner.nextInt();
            scanner.nextLine();    
            
            switch (opcao) {
                case 1:
                    System.out.print(livroService.buscarLivro(1,""));
                    break;
                case 2:
                    System.out.print("Digite o titulo do livro: ");
                    valorBuscar = scanner.nextLine();
                    System.out.print(livroService.buscarLivro(3,valorBuscar));
                    break;
                case 3:
                    System.out.print("Digite o autor do livro: ");
                    valorBuscar = scanner.nextLine();
                    System.out.print(livroService.buscarLivro(4,valorBuscar));
                    break;
                case 4:
                    System.out.print("Digite o idioma do livro: ");
                    valorBuscar = scanner.nextLine();
                    System.out.print(livroService.buscarLivro(5,valorBuscar));
                    break;
                case 5:
                    System.out.print("Digite a editora do livro: ");
                    valorBuscar = scanner.nextLine();
                    System.out.print(livroService.buscarLivro(6,valorBuscar));
                    break;
                case 6:
                    System.out.print("Digite a categoria do livro: ");
                    valorBuscar = scanner.nextLine();
                    System.out.print(livroService.buscarLivro(7,valorBuscar));
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao < 1 || opcao > 7);
    }

    public StringBuilder mensagemBuscar (){
        return new StringBuilder("---- BUSCAR LIVRO ----\n")
            .append("1 - Todos os Livros\n")
            .append("2 - Buscar por Titulo\n")
            .append("3 - Buscar por Autor\n")
            .append("4 - Buscar por Idioma\n")
            .append("5 - Buscar por Editora\n")
            .append("6 - Buscar por Categoria\n")
            .append("7 - Voltar\n")
            .append("Escolha uma opção: ");
    }

}
