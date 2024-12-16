package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Cliente;
import java.util.List;

public interface ClienteService {

    //@param cliente
    //@requires cliente!=null
    void adicionarCliente(Cliente cliente);

    void atualizarCliente(int id, Cliente cliente);

    void excluirCliente(int id);

    List<Cliente> buscarCliente(int opcao, String valorBuscar);
}
