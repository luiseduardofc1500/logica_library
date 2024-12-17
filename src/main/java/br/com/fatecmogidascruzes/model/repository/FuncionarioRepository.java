package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {

    private static final List<Funcionario> funcionarios = new ArrayList<>();

    public static void save(Funcionario funcionario) {
        // Verifica se o funcionário com o email já existe
        if (findByEmail(funcionario.getEmail()) == null) {
            funcionarios.add(funcionario);
        } else {
            throw new IllegalArgumentException("Funcionário com o email já existe.");
        }
    }

    public static void alterarFuncionario(String email, Funcionario funcionarioAtualizado) {
        Funcionario funcionarioExistente = findByEmail(email);
        if (funcionarioExistente != null) {
            funcionarioExistente.setNome(funcionarioAtualizado.getNome());
            funcionarioExistente.setCargo(funcionarioAtualizado.getCargo());
            funcionarioExistente.setDataContratacao(funcionarioAtualizado.getDataContratacao());
        } else {
            throw new IllegalArgumentException("Funcionário com email não encontrado.");
        }
    }

    public static void removerFuncionario(String email) {
        Funcionario funcionario = findByEmail(email);
        if (funcionario != null) {
            funcionarios.remove(funcionario);
        } else {
            throw new IllegalArgumentException("Funcionário com email não encontrado.");
        }
    }

    public static List<Funcionario> findAll() {
        return new ArrayList<>(funcionarios);
    }

    public static Funcionario findByEmail(String email) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
}
