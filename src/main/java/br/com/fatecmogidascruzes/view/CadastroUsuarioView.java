package br.com.fatecmogidascruzes.view;

import br.com.fatecmogidascruzes.service.impl.ClienteServiceImpl;
import br.com.fatecmogidascruzes.service.impl.FuncionarioServiceImpl;
import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.entity.Funcionario;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

import java.util.Scanner;
import java.time.LocalDate;

public class CadastroUsuarioView {
    ClienteServiceImpl clienteService = new ClienteServiceImpl();
    FuncionarioServiceImpl funcionarioService;
    Scanner scanner = new Scanner(System.in);
    
    public void cadastro() {
        int opcao;

        do {
            System.out.print(stringMenuCadastro());
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n---- CADASTRO CLIENTE ----");
                    if(!cadastroCliente()){
                        opcao = 0;
                    }
                    break;
                case 2:
                    System.out.println("\n---- CADASTRO FUNCIONÁRIO ----");
                    if(!cadastroFuncionario()){
                        opcao = 0;
                    }
                    break;
                case 3:
                    System.out.println("\nVoltando ao menu principal...");
                    break;
                default:
                    System.out.println("\nOpção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        } while (opcao < 1 || opcao > 3);
    }

    public Boolean cadastroCliente() {
        int confirmarCadastro;

        System.out.print("\nDigite o seu e-mail: ");
        String email = scanner.next();
        System.out.print("\nDigite o seu nome: ");
        String nome = scanner.next();
        System.out.print("\nDigite uma Senha: ");
        String senha = scanner.next();
        System.out.print("\nRepetir a Senha: ");
        String senhaRepetida = scanner.next();
        System.out.print("\nDigite seu endereço (Onde vamos entregar seus pedidos): ");
        String endereco = scanner.next();
        System.out.print("\nDigite seu telefone: ");
        String telefone = scanner.next();
        System.out.print("\nEscolha um método de pagamento padrão (Pode ser alterado posteriormente): ");
        String metodoPagamento = escolherMetodoPagamento();

        senha = UsuarioValidator.validarSenhaCadastro(senha, senhaRepetida);

        StringBuilder mensagemConfirmacao = new StringBuilder("\nConfirme o cadastro:")
            .append("\nNome: ").append(nome)
            .append("\nE-mail: ").append(email)
            .append("\nEndereço: ").append(endereco)
            .append("\nTelefone: ").append(telefone)
            .append("\nMétodo de Pagamento: ").append(metodoPagamento)
            .append("\n").append(stringMenuMensagemConfirmacao());

        do{
            System.out.println(mensagemConfirmacao);
            confirmarCadastro = scanner.nextInt();
            switch (confirmarCadastro) {
                case 1:
                    clienteService.adicionarCliente(new Cliente(email, nome, senha, endereco, telefone, metodoPagamento, LocalDate.now()));
                    return true;
                case 2:
                    System.out.println("\nCadastro cancelado.");
                    break;
                default:
                    System.out.println("\nOpção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }while(confirmarCadastro < 1 || confirmarCadastro > 2);
        return false;
    }

    public boolean cadastroFuncionario() {

        int confirmarCadastro;

        System.out.print("\nDigite o e-mail do funcionário: ");
        String email = scanner.next();
        System.out.print("\nDigite o nome do funcionário: ");
        String nome = scanner.next();
        System.out.print("\nDigite a Senha: ");
        String senha = scanner.next();
        System.out.print("\nRepetir Senha: ");
        String senhaRepetida = scanner.next();
        System.out.print("\nDigite o endereço do funcionário: ");
        String endereco = scanner.next();
        System.out.print("\nDigite o telefone do funcionário: ");
        String telefone = scanner.next();
        System.out.print("\nDigite o cargo do funcionário: ");
        String cargo = scanner.next();

        senha = UsuarioValidator.validarSenhaCadastro(senha, senhaRepetida);

        StringBuilder mensagemConfirmacao = new StringBuilder("\nConfirme o cadastro:")
            .append("\nNome: ").append(nome)
            .append("\nE-mail: ").append(email)
            .append("\nEndereço: ").append(endereco)
            .append("\nTelefone: ").append(telefone)
            .append("\nCargo: ").append(cargo)
            .append(stringMenuMensagemConfirmacao());
            
        do{
            System.out.println(mensagemConfirmacao);
            confirmarCadastro = scanner.nextInt();
            switch (confirmarCadastro) {
                case 1:
                    funcionarioService.adicionarFuncionario(new Funcionario(email, nome, senha, endereco, telefone, cargo, LocalDate.now()));
                    return true;
                case 2:
                    System.out.println("\nCadastro cancelado.");
                    break;
                default:
                    System.out.println("\nOpção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }while(confirmarCadastro < 1 || confirmarCadastro > 2);
        return false;
    }

    public StringBuilder stringMenuCadastro() {
        return new StringBuilder()
            .append("\n---- CADASTRO ----")
            .append("\n1 - Cadastro Cliente")
            .append("\n2 - Cadastro Funcionário")
            .append("\n3 - Voltar ao menu principal")
            .append("\nEscolha uma opção: ");
    }
    public StringBuilder stringMenuMetodoPagamento() {
        return new StringBuilder()
            .append("\n---- MÉTODO DE PAGAMENTO ----")
            .append("\n1 - Dinheiro")
            .append("\n2 - Cartão de Crédito")
            .append("\n3 - Cartão de Débito")
            .append("\n4 - Pix")
            .append("\nEscolha uma opção: ");
    }
    public StringBuilder stringMenuMensagemConfirmacao() {
        return new StringBuilder()
            .append("\nConfirme o cadastro:")
            .append("\n1 - Confirmar")
            .append("\n2 - Cancelar")
            .append("\nEscolha uma opção: ");
    }

    public String escolherMetodoPagamento() {
        int opcao;
        String metodoPagamento = "";
        do{
            System.out.print(stringMenuMetodoPagamento());
            opcao = scanner.nextInt();
            switch(opcao){
                case 1:
                    metodoPagamento = "Dinheiro";
                    break;
                case 2:
                    metodoPagamento = "Cartão de Crédito";
                    break;
                case 3:
                    metodoPagamento = "Cartão de Débito";
                    break;
                case 4:
                    metodoPagamento = "Pix";
                default:
                    System.out.println("\nOpção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }while(opcao < 1 || opcao > 4);

        return metodoPagamento;
    }
}