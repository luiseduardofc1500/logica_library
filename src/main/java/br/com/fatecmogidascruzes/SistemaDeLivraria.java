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
        funcionarioService.adicionarFuncionario(new Funcionario("ana@email.com", "Ana", "Senha123", "Endereço da Ana", "12934567890", "Cargo da Ana", LocalDate.now()));
        funcionarioService.adicionarFuncionario(new Funcionario("ana@email.com", "Antony", "Senha321", "Endereço do Antony", "12934567890", "Cargo do Antony", LocalDate.now()));
        System.out.println(FuncionarioRepository.findAll());

        // Testando adicionar clientes
        System.out.println("\n---- ADICIONANDO CLIENTES ---");
        clienteService.adicionarCliente(new Cliente("antony@email.com", "Romulo", "dwieifds", "romolandia", "11988521035", "moedinhas de 1 centavo", LocalDate.now()));
        clienteService.adicionarCliente(new Cliente("antony@email.com", "Caio", "123456", "Palavraonao", "1198844555", "moedinhas de 1 centavo", LocalDate.now()));
        clienteService.adicionarCliente(new Cliente("l@e.com", "leo", "123", "Palavraonao", "1198844555", "moedinhas de 1 centavo", LocalDate.now()));
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

        //******************************************

        //TESTES DE ATUALIZAR ENTIDADES
        System.out.println("\n**---- ATUALIZAR ---**");

        //testando atualizar livros
        System.out.println("\n---- ATUALIZANDO LIVROS ---" );
        System.out.println(LivroRepository.findById(1));
        //testando atualizar livro erro
        livroService.atualizarLivro(1, new Livro("0123456789", "", "Biblia", "Portugues", "profeta", -1, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao"));
        System.out.println(LivroRepository.findById(1));
        System.out.println(LivroRepository.findAllWhereExistEstoque());
        //testando atualizar livro correto
        livroService.atualizarLivro(1, new Livro("0123456789", "", "Biblia", "Portugues", "profeta", 0, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao"));

        System.out.println("\n---- ATUALIZANDO FUNCIONÁRIO ---" );
        System.out.println(FuncionarioRepository.findById(1));
        funcionarioService.atualizarFuncionario(1,new Funcionario("ana@email.com", "ANA PAULA","Paulao123", "Endereço da Ana", "12934567890", "Cargo da Ana", LocalDate.now()));
        System.out.println(FuncionarioRepository.findById(1));

        clienteService.adicionarCliente(new Cliente("romulo@romail.com", "Romulo", "123", "Eunaoquero", "11988521035", "moedinhas de 1 centavo", LocalDate.now()));
        System.out.println(ClienteRepository.findAll());

        System.out.println("\n---- ATUALIZAR CLIENTE ---" );
        System.out.println(ClienteRepository.findById(1));
        clienteService.atualizarCliente(1,new Cliente("antony@email.com", "Romulo da silva", "Silvaromulo", "Romulandia", "11988521035", "moedinhas de 1 centavo", LocalDate.now()));
        System.out.println(ClienteRepository.findById(1));

        System.out.println("\n---- ATUALIZAR CATEGORIA ---" );
        categoriaService.atualizarCategoria(1,new Categoria("Romance de Época" , "Livros de Romance e Fanfics de época."));
        System.out.println(CategoriaRepository.findAllCategorias());
        categoriaService.atualizarCategoria(1,new Categoria("Romance" , "Livros de Romance e Fanfics de época."));
        System.out.println(CategoriaRepository.findAllCategorias());

        //******************************************

        //TESTES DE BUSCAR ENTIDADES
        System.out.println("\n**---- BUSCAR ---**");

        // Testando a busca de livros
        System.out.println("\n---- BUSCAR LIVROS ---" );
        System.out.println(LivroRepository.findAllWhereExistEstoque());
        System.out.println(livroService.buscarLivro(7,"Romance"));
        System.out.println(livroService.buscarLivro(8, "150.00"));
        System.out.println(livroService.buscarLivro(9, "5"));

        //data para string
        String data = LocalDate.now().toString();

        // Testando a busca de funcionario
        System.out.println("\n---- BUSCAR FUNCIONARIOS ---" );
        System.out.println(funcionarioService.buscarFuncionario(3, "Ana"));
        System.out.println(funcionarioService.buscarFuncionario(4, "ana@email.com"));
        System.out.println(funcionarioService.buscarFuncionario(3, "Antonythony"));
        System.out.println(funcionarioService.buscarFuncionario(5, "Cargo da Ana"));
        System.out.println(funcionarioService.buscarFuncionario(6, data));

        // Testando a busca de cliente
        System.out.println("\n---- BUSCAR CLIENTES ---" );
        System.out.println(clienteService.buscarCliente(3, "Romulo"));
        System.out.println(clienteService.buscarCliente(4, "romulo@romail.com"));
        System.out.println(funcionarioService.buscarFuncionario(3, "Romulandia"));
        System.out.println(clienteService.buscarCliente(5, "moedinhas de 1 centavo"));
        System.out.println(clienteService.buscarCliente(6, data));
        
        // Testando a busca de categoria
        System.out.println("\n---- BUSCAR CATEGORIA---");
        System.out.println("\nbuscando cateogira romance...");
        System.out.println(categoriaService.buscarCategoriaPorNome("Romance"));
        System.out.println("\n\nbuscando cateogira ficcao (inexistente)...");
        System.out.println(categoriaService.buscarCategoriaPorNome("Ficção"));

        // Testando a busca de pedido
        System.out.println("\n---- BUSCAR PEDIDO ---" );
        System.out.println(pedidoService.buscarPedido(1, "1"));
        System.out.println(pedidoService.buscarPedido(2, "leo123@gmail.com"));
        System.out.println(pedidoService.buscarPedido(3, "Harry Potter"));
        System.out.println(pedidoService.buscarPedido(4, "1"));

        //******************************************

        //TESTES DE EXCLUIR ENTIDADES
        System.out.println("\n**---- EXCLUIR ---**");

        //testando excluir livros
        System.out.println("\n---- EXCLUIR LIVROS ---" );
        LocalDate dataDePublicacao4 = LocalDate.of(2023, 8, 15);
        livroService.adicionarLivro(new Livro("6584956245", "9786584956247", "O Pequeno Principe", "Portugues", "Antoine de Saint-Exupery", 5, "Editora Garnier", 96, dataDePublicacao4, 19.90, "Acao e Aventura"));
        System.out.println("Tentando excluir livro com ID 1:");
        livroService.excluirLivroPorId(1);
        System.out.println("Tentando excluir livro com ISBN-10 0306406152:");
        livroService.excluirLivroPorIsbn10("0306406152");
        System.out.println("Tentando excluir livro com ISBN-13 9786584956247:");
        livroService.excluirLivroPorIsbn13("9786584956247");
        System.out.println("Tentando excluir livro com ID 6 (inexistente):");
        livroService.excluirLivroPorId(6);
        System.out.println(LivroRepository.findAllWhereExistEstoque());

        // Testando a exclusão de pedido
        System.out.println("\n---- EXCLUIR FUNCIONARIO ---" );
        System.out.println("Tentando excluir a funcionaria Ana com ID 1");
        funcionarioService.excluirFuncionario(1);
        System.out.println("Tentando excluir funcionario com ID 2 (inexistente)");
        funcionarioService.excluirFuncionario(2);
        System.out.println(FuncionarioRepository.findAll());

        // Testando a exclusão de cliente
        System.out.println("\n---- EXCLUIR CLIENTE ---" );
        System.out.println("Tentando excluir o cliente Romulo com ID 1");
        clienteService.excluirCliente(1);
        System.out.println("Tentando excluir o cliente com ID 4(inexistente)");
        clienteService.excluirCliente(4);
        System.out.println(ClienteRepository.findAll());

        // Testando a exclusão de categoria
        System.out.println("\n---- EXCLUIR CATEGORIA ---" );
        categoriaService.excluirCategoria(1);
        System.out.println(CategoriaRepository.findAllCategorias());
        System.out.println("\n tentando excluir categoria com ID 2 (inexistente)");
        categoriaService.excluirCategoria(2);

        //******************************************
        funcionarioService.adicionarFuncionario(new Funcionario("ana@email.com","Ana","Senha123", "Endereço da Ana", "12934567890", "Cargo da Ana", LocalDate.now()));

        //TESTES MENUS
        System.out.println("\n\n\n**---- MENUS ---**");
        MenuView menuView = new MenuView();
        menuView.menuInicial();
    }
}