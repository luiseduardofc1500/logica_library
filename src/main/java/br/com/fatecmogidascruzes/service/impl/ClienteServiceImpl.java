package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.repository.ClienteRepository;
import br.com.fatecmogidascruzes.service.ClienteService;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteServiceImpl implements ClienteService {

    @Override
    public void adicionarCliente(Cliente cliente) {
        try {
            if(UsuarioValidator.validarEmail(cliente)){
                ClienteRepository.save(cliente);
                System.out.println("Cliente " + cliente.getNome() + " adicionado com sucesso!");

            } else{ 
                throw new IllegalArgumentException("Cliente não pode ser adicionado, email já cadastrado.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void atualizarCliente(long id, Cliente cliente) {
        try {
            ClienteRepository.atualizarCliente(id, cliente);
            System.out.println("Cliente " + cliente.getNome() + " atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Cliente> buscarCliente(int opcao, String valorBuscar) {
        List<Cliente> clientesEncontrados = new ArrayList<>();

        switch(opcao){
            case 1:
                clientesEncontrados = ClienteRepository.findAll();
                break;
            case 2:
                clientesEncontrados.add(ClienteRepository.findById(Integer.parseInt(valorBuscar)));
                break;
            case 3:
                clientesEncontrados = ClienteRepository.findByNome(valorBuscar);
                break;
            case 4:
                clientesEncontrados.add(ClienteRepository.findByEmail(valorBuscar));
                break;
            case 5:
                clientesEncontrados = ClienteRepository.findByMetodoPagamento(valorBuscar);
                break;
            case 6:
                clientesEncontrados = ClienteRepository.findByDataCadastro(LocalDate.parse(valorBuscar));
                break;
            default:
                System.out.println("Opção invalida.");
                break;
        }

        if (clientesEncontrados == null || clientesEncontrados.isEmpty()) {
            System.out.println("Cliente buscado por '" + valorBuscar + "' não encontrado.");
        }

        return clientesEncontrados;
    }
   
    @Override
    public void excluirCliente(int id) {
        try {
            ClienteRepository.removerCliente(id);
            System.out.println("Cliente removido com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor, verifique o ID informado.");
        }
    }
}
