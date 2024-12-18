package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Funcionario;
import br.com.fatecmogidascruzes.model.repository.FuncionarioRepository;
import br.com.fatecmogidascruzes.service.FuncionarioService;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

import java.util.List;

public class FuncionarioServiceImpl implements FuncionarioService {

    @Override
    public void adicionarFuncionario(Funcionario funcionario) {
        if (UsuarioValidator.validarEmail(funcionario)) {
            FuncionarioRepository.save(funcionario);
            log("Funcionário " + funcionario.getNome() + " adicionado com sucesso!");
        } else {
            log("Email inválido. Por favor, insira um email válido.");
        }

    }

    //@ skipesc
    private void log(String message) {
        System.out.println(message);
    }

    //@ skipesc
    public void excluirFuncionario(String email) {
        try {
            FuncionarioRepository.removerFuncionario(email);
            log("Funcionário removido com sucesso!");
        } catch (IllegalArgumentException e) {
            log(e.getMessage() + " Verifique o email informado.");
        }
    }

    //@ skipesc
    public List<Funcionario> buscarTodosFuncionarios() {
        return FuncionarioRepository.findAll();
    }

    //@ skipesc
    public Funcionario buscarPorEmail(String email) {
        Funcionario funcionario = FuncionarioRepository.findByEmail(email);
        if (funcionario == null) {
            log("Funcionário com email '" + email + "' não encontrado.");
        }
        return funcionario;
    }
}
