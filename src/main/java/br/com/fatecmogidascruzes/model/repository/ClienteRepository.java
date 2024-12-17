package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteRepository {

    /*@
      @ public invariant clientes != null;
      @ public invariant (\forall int i; 0 <= i && i < clientes.size(); clientes.get(i) != null);
      @*/
    private static final List<Cliente> clientes = new ArrayList<>();

    /*@
      @ requires cliente != null;
      @ requires cliente.getEmail() != null;
      @ requires findByEmail(cliente.getEmail()) == null;
      @ ensures clientes.contains(cliente);
      @ also
      @ signals (IllegalArgumentException e) findByEmail(cliente.getEmail()) != null;
      @*/
    public static void save(Cliente cliente) {
        Cliente clienteExistente = findByEmail(cliente.getEmail());
        if (clienteExistente == null) {
            clientes.add(cliente);
        } else {
            throw new IllegalArgumentException("Cliente com o email já existe.");
        }
    }

    /*@
      @ requires email != null;
      @ requires clienteAtualizado != null;
      @ requires findByEmail(email) != null;
      @ ensures (\forall Cliente c; c != findByEmail(email) ==> \old(clientes).contains(c) ==> clientes.contains(c));
      @ ensures findByEmail(email).getNome().equals(clienteAtualizado.getNome());
      @ ensures findByEmail(email).getMetodoPagamento().equals(clienteAtualizado.getMetodoPagamento());
      @ ensures findByEmail(email).getDataCadastro().equals(clienteAtualizado.getDataCadastro());
      @ also
      @ signals (IllegalArgumentException e) findByEmail(email) == null;
      @*/
    public static void atualizarCliente(String email, Cliente clienteAtualizado) {
        Cliente clienteExistente = findByEmail(email);
        if (clienteExistente != null) {
            clienteExistente.setNome(clienteAtualizado.getNome());
            clienteExistente.setMetodoPagamento(clienteAtualizado.getMetodoPagamento());
        } else {
            throw new IllegalArgumentException("Cliente com email não encontrado.");
        }
    }

    /*@
      @ requires cliente != null;
      @ requires clientes.contains(cliente);
      @
      @ ensures !clientes.contains(cliente);
      @
      @ also
      @ signals (IllegalArgumentException e) !\old(clientes).contains(cliente);
      @*/
    public static void removerCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
        } else {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
    }

    /*@
      @ ensures \result != null;
      @ ensures \result.size() == clientes.size();
      @ ensures (\forall int i; 0 <= i && i < \result.size(); \result.get(i) == clientes.get(i));
      @*/
    public static List<Cliente> findAll() {
        return new ArrayList<>(clientes);
    }

    /*@
      @ requires email != null;
      @ ensures (\exists Cliente c; clientes.contains(c) && c.getEmail().equalsIgnoreCase(email); \result == c)
      @   || \result == null;
      @*/
    public static Cliente findByEmail(String email) {
        return clientes.stream()
                .filter(cliente -> cliente.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
}
