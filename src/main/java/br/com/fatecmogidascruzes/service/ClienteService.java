package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Cliente;

public interface ClienteService {

     //@ requires cliente != null && cliente.getEmail() != null;
    void adicionarCliente(Cliente cliente);



}
