package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteRepository {

    private static final List<Cliente> clientes = new ArrayList<>();
    private static long ultimoId = 0;

    public static void save(Cliente cliente) {
        cliente.setId(++ultimoId);
        clientes.add(cliente);
    }
   
    public static void atualizarCliente(long id, Cliente cliente) {
        int index = findIndexPorId(id);
        if (index != -1) {
            cliente.setId(id);
            clientes.set(index, cliente);
        }
        else{
            throw new IllegalArgumentException("Ocorreu algo de errado ao atualizar informações do cliente, por favor verifique as informações e tente novamente");
        }
    }

    public static void removerCliente(long id) {
        Cliente cliente = findById(id);
        if (cliente != null) {
            clientes.remove(cliente);
        } else 
            throw new IllegalArgumentException("Cliente não encontrado.");
    }

    public static List<Cliente> findAll() {
        return clientes;
    }

    private static int findIndexPorId(long id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst()
                .map(clientes::indexOf)
                .orElse(-1);
    }

    public static Cliente findById(long id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst().orElse(null);
    }

    public static List<Cliente> findByNome(String nome) {
        return clientes.stream()
                .filter(cliente -> cliente.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public static Cliente findByEmail(String email) {
        return clientes.stream()
                .filter(cliente -> cliente.getEmail().toUpperCase().contains(email.toUpperCase()))
                .findFirst().orElse(null);
    }

    public static List<Cliente> findByMetodoPagamento(String metodoPagamento) {
        return clientes.stream()
                .filter(cliente -> cliente.getMetodoPagamento().toUpperCase().contains(metodoPagamento.toUpperCase()))
                .collect(Collectors.toList());
    }

    public static List<Cliente> findByDataCadastro(LocalDate dataCadastro) {
        return clientes.stream()
                .filter(cliente -> cliente.getDataCadastro().equals(dataCadastro))
                .collect(Collectors.toList());
    }

}
