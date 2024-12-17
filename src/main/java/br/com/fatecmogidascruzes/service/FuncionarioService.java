package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Funcionario;

import java.util.List;

public interface FuncionarioService {
    void adicionarFuncionario(Funcionario funcionario);
    void excluirFuncionario(String email);
    List<Funcionario> buscarTodosFuncionarios();
    Funcionario buscarPorEmail(String email);
}
