package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {
    //@ spec_public
    private static final List<Funcionario> funcionarios = new ArrayList<>();

    //@ requires funcionario != null;
    public static void save(Funcionario funcionario) {
        if (findByEmail(funcionario.getEmail()) == null) {
            funcionarios.add(funcionario);
        } else {
            throw new IllegalArgumentException("Funcionário com o email já existe.");
        }
    }

    //@ requires email != null;
    public static void removerFuncionario(String email) {
        //@ nullable
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



    //@ requires email != null;
    //@ ensures (\result == null || (\result.getEmail() != null && \result.getEmail().equalsIgnoreCase(email)));
    //@ ensures (\forall int i; 0 <= i && i < funcionarios.size(); !funcionarios.get(i).getEmail().equalsIgnoreCase(email)) ==> \result == null;
    //@ nullable
    //@ pure
    public static Funcionario findByEmail(String email) {
        //@ loop_invariant 0 <= j && j <= funcionarios.size();
        //@ loop_invariant (\forall int k; 0 <= k && k < j; !funcionarios.get(k).getEmail().equalsIgnoreCase(email));
        //@ decreasing funcionarios.size() - j;
        for (int j = 0; j < funcionarios.size(); j++) {
            //@ assume funcionarios.get(j) != null;
            Funcionario funcionario = funcionarios.get(j);
            if (funcionario.getEmail().equalsIgnoreCase(email)) {
                //@ assert funcionario.getEmail().equalsIgnoreCase(email);
                return funcionario;
            }
        }
        //@ assert (\forall int i; 0 <= i && i < funcionarios.size(); !funcionarios.get(i).getEmail().equalsIgnoreCase(email));
        return null;
    }



}
