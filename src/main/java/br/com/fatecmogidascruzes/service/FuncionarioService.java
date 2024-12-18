package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Funcionario;

import java.util.List;

public interface FuncionarioService {
    //@ requires funcionario != null && funcionario.getEmail() != null;
    void adicionarFuncionario(Funcionario funcionario);

}
