package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Funcionario;
import br.com.fatecmogidascruzes.model.repository.FuncionarioRepository;
import br.com.fatecmogidascruzes.service.FuncionarioService;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioServiceImpl implements FuncionarioService {

    @Override
    public void adicionarFuncionario(Funcionario funcionario) throws IllegalArgumentException{
        try {
            if(UsuarioValidator.validarEmail(funcionario)){
                FuncionarioRepository.save(funcionario);
                System.out.println("Funcionario " + funcionario.getNome() + " adicionado com sucesso!");
            } else{ 
                throw new IllegalArgumentException("Funcionario não pode ser adicionado, email já cadastrado.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void atualizarFuncionario(long id, Funcionario funcionario) {
        try {
            FuncionarioRepository.alterarFuncionario(id, funcionario);
            System.out.println("Funcionario " + funcionario.getNome() + " atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    
    }

    @Override
    public void excluirFuncionario(int id) {
        try {
            FuncionarioRepository.removerFuncionario(id);
            System.out.println("Funcionario removido com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor, verifique o ID informado.");
        }
    }

    @Override
    public List<Funcionario> buscarFuncionario(int opcao, String valorBuscar) {
        List<Funcionario> funcionariosEncontrados = new ArrayList<>();

        switch(opcao){
            case 1:
                funcionariosEncontrados = FuncionarioRepository.findAll();
                break;
            case 2:
                funcionariosEncontrados.add(FuncionarioRepository.findById(Integer.parseInt(valorBuscar)));
                break;
            case 3:
                funcionariosEncontrados = FuncionarioRepository.findByNome(valorBuscar);
                break;
            case 4:
                funcionariosEncontrados.add(FuncionarioRepository.findByEmail(valorBuscar));
                break;
            case 5:
                funcionariosEncontrados = FuncionarioRepository.findByCargo(valorBuscar);
                break;
            case 6:
                funcionariosEncontrados = FuncionarioRepository.findByDataContratacao(LocalDate.parse(valorBuscar));
                break;
            default:
                System.out.println("Opção invalida.");
                break;
        }

        if (funcionariosEncontrados == null || funcionariosEncontrados.isEmpty()) {
            System.out.println("Funcionario buscado por '" + valorBuscar + "' não encontrado.");
        }

        return funcionariosEncontrados;
    }
}
