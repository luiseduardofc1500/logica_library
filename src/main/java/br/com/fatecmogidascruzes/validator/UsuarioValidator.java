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


    /*@
      requires usuario != null && usuario.getEmail() != null;
      ensures \result == true || \result == false;
    @*/
    public static boolean validarEmail(Usuario usuario) {
        if (usuario instanceof Funcionario) {
            List<Funcionario> listaDeFuncionarios = FuncionarioRepository.findAll();
            for (Funcionario funcionario : listaDeFuncionarios) {
                if (funcionario.getEmail().equals(usuario.getEmail())) {
                    return false;
                }
            }
        } else if (usuario instanceof Cliente) {
            List<Cliente> listaDeClientes = ClienteRepository.findAll();
            for (Cliente cliente : listaDeClientes) {
                if (cliente.getEmail().equals(usuario.getEmail())) {
                    return false;
                }
            }
        }
        return true;
    }

    /*@
      requires senha != null && senhaRepetida != null;
      ensures \result == (senha.equals(senhaRepetida));
    @*/
    public static boolean senhasCoincidem(String senha, String senhaRepetida) {
        return senha.equals(senhaRepetida);
    }

    /*@
      requires email != null && senha != null && (tipoUsuario == 1 || tipoUsuario == 2);
      ensures \result == true || \result == false;
    @*/
    public static boolean validarLogin(String email, String senha, int tipoUsuario) {
        if (tipoUsuario == 1) {
            //@ nullable
            Cliente cliente = ClienteRepository.findByEmail(email);
            return cliente != null && cliente.getSenha().equals(senha);
        } else {
            //@ nullable
            Funcionario funcionario = FuncionarioRepository.findByEmail(email);
            return funcionario != null && funcionario.getSenha().equals(senha);
        }
    }

    //Parte com o sout e estava quebrando abaixo. Separei a logica acima para poder validar com o openJML.

    //@ skipesc
    public static String validarSenhaCadastro(String senha, String senhaRepetida) {
        boolean repetir;
        do {
            if (senhasCoincidem(senha, senhaRepetida)) {
                repetir = false;
            } else {
                System.out.println("\nAs senhas não coincidem. Tente novamente.");
                System.out.print("\nDigite a Senha: ");
                senha = scanner.next();
                System.out.print("\nRepetir a Senha: ");
                System.out.flush();
                senhaRepetida = scanner.next();
                repetir = true;
            }
        } while (repetir);
        return senha;
    }

    //@ skipesc
    public static Boolean validarLogin(String email, String senha, int tipoUsuario, boolean exibirMensagens) {
        boolean resultado = validarLogin(email, senha, tipoUsuario);
        if (exibirMensagens) {
            if (resultado) {
                System.out.println("Login efetuado com sucesso!");

            } else {
                System.out.println("Usuário ou senha incorreta.");
            }
        }
        return resultado;
    }

}
