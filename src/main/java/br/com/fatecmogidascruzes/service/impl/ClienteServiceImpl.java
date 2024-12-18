package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.repository.ClienteRepository;
import br.com.fatecmogidascruzes.service.ClienteService;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {


    @Override
    public void adicionarCliente(Cliente cliente) {
        if (UsuarioValidator.validarEmail(cliente)) {
            ClienteRepository.save(cliente);
            log("Cliente " + cliente.getNome() + " adicionado com sucesso!");
        } else {
            log("Email inválido. Por favor, insira um email válido.");
        }
    }

    //@ skipesc
    private void log(String message) {
        System.out.println(message);
    }


    //@ skipesc
    public Cliente buscarClientePorEmail(String email) {
        Cliente cliente = ClienteRepository.findByEmail(email);
        if (cliente == null) {
            log("Cliente com email: " + email + " não encontrado!");
        }
        return cliente;
    }
    //@ skipesc
    public void excluirCliente(String email) {
        try{
            ClienteRepository.removerCliente(email);
            log("Cliente com email:  " + email + " removido com sucesso!");
        } catch (IllegalArgumentException e){
            log(e.getMessage() + " Verifique o email informado.");
        }
    }

}
