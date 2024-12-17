package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Funcionario;
import br.com.fatecmogidascruzes.model.repository.FuncionarioRepository;
import br.com.fatecmogidascruzes.service.FuncionarioService;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

import java.util.List;

public class FuncionarioServiceImpl implements FuncionarioService {

    @Override
    public void adicionarFuncionario(Funcionario funcionario) {
        try {
            if (UsuarioValidator.validarEmail(funcionario)) {
                FuncionarioRepository.save(funcionario);
                System.out.println("Funcionário " + funcionario.getNome() + " adicionado com sucesso!");
            } else {
                throw new IllegalArgumentException("Email já cadastrado.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void excluirFuncionario(String email) {
        try {
            FuncionarioRepository.removerFuncionario(email);
            System.out.println("Funcionário removido com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Verifique o email informado.");
        }
    }

    @Override
    public List<Funcionario> buscarTodosFuncionarios() {
        return FuncionarioRepository.findAll();
    }

    @Override
    public Funcionario buscarPorEmail(String email) {
        Funcionario funcionario = FuncionarioRepository.findByEmail(email);
        if (funcionario == null) {
            System.out.println("Funcionário com email '" + email + "' não encontrado.");
        }
        return funcionario;
    }
}
