package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Cliente;

public interface ClienteService {

    void adicionarCliente(Cliente cliente);

    void atualizarCliente(String email, Cliente cliente);

    void excluirCliente(String email);

    Cliente buscarClientePorEmail(String email);
}
