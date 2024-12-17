package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.repository.ClienteRepository;
import br.com.fatecmogidascruzes.service.ClienteService;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {

    @Override
    public void adicionarCliente(Cliente cliente) {
        try {
            if (UsuarioValidator.validarEmail(cliente)) {
                ClienteRepository.save(cliente);
                System.out.println("Cliente " + cliente.getNome() + " adicionado com sucesso!");
            } else {
                throw new IllegalArgumentException("Email já cadastrado.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void atualizarCliente(String email, Cliente clienteAtualizado) {
        try {
            Cliente clienteExistente = ClienteRepository.findByEmail(email);
            if (clienteExistente != null) {
                clienteExistente.setNome(clienteAtualizado.getNome());
                clienteExistente.setMetodoPagamento(clienteAtualizado.getMetodoPagamento());
                ClienteRepository.save(clienteExistente);
                System.out.println("Cliente com email " + email + " atualizado com sucesso!");
            } else {
                throw new IllegalArgumentException("Cliente com email não encontrado.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Cliente buscarClientePorEmail(String email) {
        Cliente cliente = ClienteRepository.findByEmail(email);
        if (cliente == null) {
            System.out.println("Cliente com email '" + email + "' não encontrado.");
        }
        return cliente;
    }

    @Override
    public void excluirCliente(String email) {
        try {
            Cliente cliente = ClienteRepository.findByEmail(email);
            if (cliente != null) {
                ClienteRepository.removerCliente(cliente);
                System.out.println("Cliente com email '" + email + "' removido com sucesso!");
            } else {
                throw new IllegalArgumentException("Cliente com email não encontrado.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
