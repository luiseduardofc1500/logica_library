package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Funcionario;
import java.util.List;

public interface FuncionarioService {

    void adicionarFuncionario(Funcionario funcionario);
    void atualizarFuncionario(long id, Funcionario funcionario);
    void excluirFuncionario(int id);
    List<Funcionario> buscarFuncionario(int opcao, String valorBuscar);
}
