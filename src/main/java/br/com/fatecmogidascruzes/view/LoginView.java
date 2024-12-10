package br.com.fatecmogidascruzes.view;

import java.util.Scanner;

import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.entity.Funcionario;
import br.com.fatecmogidascruzes.model.entity.Usuario;
import br.com.fatecmogidascruzes.model.repository.ClienteRepository;
import br.com.fatecmogidascruzes.model.repository.FuncionarioRepository;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

public class LoginView {

    Scanner scanner = new Scanner(System.in);

    public Usuario login() {

        int opcao;

        do {
            System.out.print(stringMenuLogin());
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n---- LOGIN CLIENTE ----");
                    return loginCliente();
                    
                case 2:
                    System.out.println("\n---- LOGIN FUNCIONÁRIO ----");
                    return loginFuncionario();
                case 3:
                    System.out.println("\nVoltando ao menu inicial...");
                    break;
                default:
                    System.out.println("\nOpção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }while(opcao < 1 || opcao > 3);

        return null;
    }

    public Cliente loginCliente() {
        System.out.print("\nDigite seu Email:");
        String email = scanner.next();
        System.out.print("\nDigite sua senha:");
        String senha = scanner.next();

        if(Boolean.TRUE.equals(UsuarioValidator.validarLogin(email, senha, 1))){
            return ClienteRepository.findByEmail(email);
        }
        return null;
    }

    public Funcionario loginFuncionario() {
        System.out.print("\nDigite o Email de funcionário:");
        String email = scanner.next();
        System.out.print("\nDigite a senha:");
        String senha = scanner.next();

        if(Boolean.TRUE.equals(UsuarioValidator.validarLogin(email, senha, 2))){
            return FuncionarioRepository.findByEmail(email);
        }
        return null;
    }

    public StringBuilder stringMenuLogin() {
        StringBuilder mensagemOpcoes = new StringBuilder();
            mensagemOpcoes.append("\n---- LOGIN ----");
            mensagemOpcoes.append("\n1 - Login cliente");
            mensagemOpcoes.append("\n2 - Login funcionário");
            mensagemOpcoes.append("\n3 - Voltar");
            mensagemOpcoes.append("\nEscolha uma opção: ");
        return mensagemOpcoes;
    }
}