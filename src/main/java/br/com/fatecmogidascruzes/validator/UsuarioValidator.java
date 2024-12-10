package br.com.fatecmogidascruzes.validator;

import br.com.fatecmogidascruzes.model.entity.Usuario;
import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.entity.Funcionario;
import br.com.fatecmogidascruzes.model.repository.ClienteRepository;
import br.com.fatecmogidascruzes.model.repository.FuncionarioRepository;

import java.util.List;
import java.util.Scanner;

public class UsuarioValidator {

    private static final Scanner scanner = new Scanner(System.in);

    public static boolean validarEmail(Usuario usuario) {
        if (usuario instanceof Funcionario) {
            List<Funcionario> listaDeFuncionarios = FuncionarioRepository.findAll();
            for (Funcionario funcionario : listaDeFuncionarios) {
                if (funcionario.getEmail().equals(usuario.getEmail())) {
                    return false;
                }
            }
        } else if (usuario instanceof Cliente){
            List<Cliente> listaDeClientes = ClienteRepository.findAll();
            for (Cliente cliente : listaDeClientes) {
                if (cliente.getEmail().equals(usuario.getEmail())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String validarSenhaCadastro(String senha, String senhaRepetida) {
        boolean repetir;
        do{
            if(senha.equals(senhaRepetida)){
                repetir = false;
            }else{
                System.out.println("\nAs senhas não coincidem. Tente novamente.");
                System.out.print("\nDigite a Senha: ");
                senha = scanner.next();
                System.out.print("\nRepetir a Senha: ");
                senhaRepetida = scanner.next();
                repetir = true;
            }
        }while(repetir);
        return senha;
    }

    public static Boolean validarLogin(String email, String senha, int tipoUsuario) {
        if(tipoUsuario == 1){    
            if(ClienteRepository.findByEmail(email) != null){
                Cliente cliente = ClienteRepository.findByEmail(email);
                if(cliente.getSenha().equals(senha)){
                    System.out.println("Login efetuado com sucesso!");
                    return true;
                } else {
                    System.out.println("Usuario ou senha incorreta.");
                    return false;
                }
            } else {
                System.out.println("Usuário ou senha incorreta.");
                return false;
            }
        }
        if(tipoUsuario == 2){
            if(FuncionarioRepository.findByEmail(email) != null){
                Funcionario funcionario = FuncionarioRepository.findByEmail(email);
                if(funcionario.getSenha().equals(senha)){
                    System.out.println("Login efetuado com sucesso!");
                    return true;
                } else {
                    System.out.println("Usuario ou senha incorreta.");
                    return false;
                }
            } else {
                System.out.println("Usuário ou senha incorreta.");
                return false;
            }   
        }
        return null;
    }
    

}
