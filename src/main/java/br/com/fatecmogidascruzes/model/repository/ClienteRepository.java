package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.entity.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    //@ spec_public
    private static final List<Cliente> clientes = new ArrayList<>();

    //    /*@
    //      @ requires cliente != null;
    //      @ requires cliente.getEmail() != null;
    //      @ requires findByEmail(cliente.getEmail()) == null;
    //      @*/
    public static void save(Cliente cliente) {
        //@ nullable
        Cliente clienteExistente = findByEmail(cliente.getEmail());
        if (clienteExistente == null) {
            clientes.add(cliente);
        } else {
            throw new IllegalArgumentException("Cliente com o email já existe.");
        }
    }



    //@ requires email != null;
    public static void removerCliente(String email) {
        //@ nullable
        Cliente cliente = findByEmail(email);
        if (cliente != null) {
            clientes.remove(cliente);
        } else {
            throw new IllegalArgumentException("Cliente com email não encontrado.");
        }
    }


    public static List<Cliente> findAll() {
        return new ArrayList<>(clientes);
    }

    //@ requires email != null;
    //@ ensures (\result == null || (\result.getEmail() != null && \result.getEmail().equalsIgnoreCase(email)));
    //@ ensures (\forall int i; 0 <= i && i < clientes.size(); !clientes.get(i).getEmail().equalsIgnoreCase(email)) ==>
    //@ \result == null;
    //@ nullable
    //@ pure
    public static Cliente findByEmail(String email) {
        //@ loop_invariant 0 <= j && j <= clientes.size();
        //@ loop_invariant (\forall int k; 0 <= k && k < j; !clientes.get(k).getEmail().equalsIgnoreCase(email));
        //@ decreasing clientes.size() - j;
        for (int j = 0; j < clientes.size(); j++) {
            //@ assume clientes.get(j) != null;
            Cliente cliente = clientes.get(j);
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                //@ assert cliente.getEmail().equalsIgnoreCase(email);
                return cliente;
            }
        }
        //@ assert (\forall int i; 0 <= i && i < clientes.size(); !clientes.get(i).getEmail().equalsIgnoreCase(email));
        return null;
    }
}
