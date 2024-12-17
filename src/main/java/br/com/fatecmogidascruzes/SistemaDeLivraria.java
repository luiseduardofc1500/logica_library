package br.com.fatecmogidascruzes;

import java.time.LocalDate;
import java.util.List;
import br.com.fatecmogidascruzes.model.entity.*;
import br.com.fatecmogidascruzes.model.repository.CategoriaRepository;
import br.com.fatecmogidascruzes.model.repository.ClienteRepository;
import br.com.fatecmogidascruzes.model.repository.FuncionarioRepository;
import br.com.fatecmogidascruzes.model.repository.LivroRepository;
import br.com.fatecmogidascruzes.model.repository.PedidoRepository;
import br.com.fatecmogidascruzes.service.impl.*;
import br.com.fatecmogidascruzes.view.MenuView;

public class SistemaDeLivraria {
    public static void main(String[] args) {

        // Services
        LivroServiceImpl livroService = new LivroServiceImpl();
        FuncionarioServiceImpl funcionarioService = new FuncionarioServiceImpl();
        ClienteServiceImpl clienteService = new ClienteServiceImpl();
        CategoriaServiceImpl categoriaService = new CategoriaServiceImpl();
        PedidoServiceImpl pedidoService = new PedidoServiceImpl();

        //******************************************//

        //TESTES DE ADICIONAR ENTIDADES
        System.out.println("\n**---- ADICIONAR ---**");

        //data de publicacao
        LocalDate dataDePublicacao = LocalDate.of(0, 1, 1);
        LocalDate dataDePublicacao1 = LocalDate.of(2020, 7, 20);
        LocalDate dataDePublicacao2 = LocalDate.of(2018, 5, 15);
        LocalDate dataDePublicacao3 = LocalDate.of(2016, 3, 10);

        //Testando adicionar livros
        System.out.println("\n---- ADICIONAR LIVROS ---");
        livroService.adicionarLivro(new Livro("0123456789", "", "Biblia", "Portugues", "Jesus", 7, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao"));
        livroService.adicionarLivro(new Livro("0306406152", "", "O Alquimista", "Portugues", "Paulo Coelho", 10, "HarperCollins", 200, dataDePublicacao1, 150.00, "Romance"));
        livroService.adicionarLivro(new Livro("0060930314", "", "1984", "Ingles", "George Orwell", 5, "Secker & Warburg", 300, dataDePublicacao2, 200.00, "Ficção Científica"));
        livroService.adicionarLivro(new Livro("0451524934", "", "Dom Quixote", "Espanhol", "Miguel de Cervantes", 7, "Francisco de Robles", 1000, dataDePublicacao3, 250.00, "Romance"));

        // Testando adicionar funcionarios
        System.out.println("\n---- ADICIONANDO FUNCIONARIOS ---");
        funcionarioService.adicionarFuncionario(new Funcionario("ana@email.com", "Ana", "Senha$1sdsd23", "Endereço da Ana", "12934567890", "Cargo da Ana", LocalDate.now()));
        funcionarioService.adicionarFuncionario(new Funcionario("antony@email.com", "Antony", "Senha$32dsds1", "Endereço do Antony", "12934567890", "Cargo do Antony", LocalDate.now()));
        System.out.println(FuncionarioRepository.findAll());

        // Testando adicionar clientes
        System.out.println("\n---- ADICIONANDO CLIENTES ---");
        clienteService.adicionarCliente(new Cliente("antony@email.com", "Romulo", "dwieidsds#Lfds", "romolandia", "11988521035", "moedinhas de 1 centavo"));
        clienteService.adicionarCliente(new Cliente("antony@email.com", "Caio", "123$4Ldsd56", "Palavraonao", "1198844555", "moedinhas de 1 centavo"));
        clienteService.adicionarCliente(new Cliente("l@e.com", "leo", "1dsdsdsdsdsdL2#3", "Paldsdavra$onao", "1198844555", "moedinhas de 1 centavo"));
        System.out.println(ClienteRepository.findAll());

        // Testando adicionar categorias
        System.out.println("\n---- ADICIONAR CATEGORIA ---" );
        categoriaService.adicionarCategoria(new Categoria("Romance" , "Livros de Romance e Fanfics."));
        System.out.println(CategoriaRepository.findAllCategorias());

        //teste de adicionar de pedido
        System.out.println("\n---- ADICIONAR PEDIDO ---" );
        List<Livro> livrosComprados = LivroRepository.findByTituloLista("1984");
        livrosComprados.addAll(LivroRepository.findByTituloLista("Dom Quixote"));
        pedidoService.adicionarPedido(new Pedido("leo123@gmail.com", "A culpa é das Estrelas", LocalDate.now(), 1, 50.0, "fatec"));
        pedidoService.adicionarPedido(new Pedido("leo123@gmail.com", "Harry Potter", LocalDate.now(), 1, 50.0, "fatec"));
        System.out.println(PedidoRepository.findAll());



        //TESTES DE EXCLUIR ENTIDADES
        System.out.println("\n**---- EXCLUIR ---**");

        //testando excluir livros
        System.out.println("\n---- EXCLUIR LIVROS ---" );
        livroService.excluirLivroPorId(1); // Excluir livro com ID 1
        livroService.excluirLivroPorIsbn10("0306406152"); // Excluir livro com ISBN-10
        livroService.excluirLivroPorIsbn13("9786584956247"); // Excluir livro com ISBN-13
        System.out.println(LivroRepository.findAllWhereExistEstoque());

        // Testando a exclusão de pedido
        System.out.println("\n---- EXCLUIR FUNCIONARIO ---" );
        funcionarioService.excluirFuncionario("leo123@gmail.com"); // Excluir funcionario com ID 1
        System.out.println(FuncionarioRepository.findAll());

        // Testando a exclusão de cliente
        System.out.println("\n---- EXCLUIR CLIENTE ---" );
        clienteService.excluirCliente("leo123@gmail.com"); // Excluir cliente com ID 1
        System.out.println(ClienteRepository.findAll());

        // Testando a exclusão de categoria
        System.out.println("\n---- EXCLUIR CATEGORIA ---" );
        categoriaService.excluirCategoria(1); // Excluir categoria com ID 1
        System.out.println(CategoriaRepository.findAllCategorias());

        //******************************************

        // Adicionar novo funcionário para continuar testes
        funcionarioService.adicionarFuncionario(new Funcionario("ana@email.com", "Ana", "Senha%dsds123", "Endereço da Ana", "12934567890", "Cargo da Ana", LocalDate.now()));

        //TESTES MENUS
        System.out.println("\n\n\n**---- MENUS ---**");
        MenuView menuView = new MenuView();
        menuView.menuInicial();
    }
}
