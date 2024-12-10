    package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Funcionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioRepository {

    private static final List<Funcionario> funcionarios = new ArrayList<>();
    private static long ultimoId = 0;

    public static void save(Funcionario funcionario) {
        funcionario.setId(++ultimoId);
        funcionarios.add(funcionario);
    }

    public static void alterarFuncionario(long id, Funcionario funcionario) {
        int index = findIndexPorId(id);
        if (index != -1) {
            funcionario.setId(id);
            funcionarios.set(index, funcionario);
        }
        else{
            throw new IllegalArgumentException("Ocorreu algo de errado ao atualizar informações do funcionario, por favor verifique as informações e tente novamente");
        }
    }

    public static void removerFuncionario(long id) {
        Funcionario funcionario = findById(id);
        if (funcionario != null) {
            funcionarios.remove(funcionario);
        } else 
            throw new IllegalArgumentException("Funcionario não encontrado.");
    }

    public static List<Funcionario> findAll() {
        return funcionarios;
    }

    public static int findIndexPorId(long id) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getId() == id)
                .findFirst()
                .map(funcionarios::indexOf)
                .orElse(-1);
    }
    
    public static Funcionario findById(long id) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getId() == id)
                .findFirst().orElse(null);
    }

    public static List<Funcionario> findByNome(String nome) {
        return funcionarios.stream()
                .filter(cliente -> cliente.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public static Funcionario findByEmail(String email) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getEmail().toUpperCase().contains(email.toUpperCase()))
                .findFirst().orElse(null);
    }

    public static List<Funcionario> findByCargo(String cargo) {
        return funcionarios.stream()
                .filter(cliente -> cliente.getCargo().toUpperCase().contains(cargo.toUpperCase()))
                .collect(Collectors.toList());
    }

    public static List<Funcionario> findByDataContratacao(LocalDate dataContratacao) {
        return funcionarios.stream()
                .filter(cliente -> cliente.getDataContratacao().equals(dataContratacao))
                .collect(Collectors.toList());
    }

}
