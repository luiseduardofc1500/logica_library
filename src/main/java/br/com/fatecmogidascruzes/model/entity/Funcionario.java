package br.com.fatecmogidascruzes.model.entity;

import java.time.LocalDate;

public class Funcionario extends Usuario {
    //@ spec_public
    private String cargo;

    //@ spec_public
    private LocalDate dataContratacao;

    //@ public normal_behavior
    //@   requires nome != "";
    //@   requires email != "" && email.endsWith("@cliente.com") ;
    //@   requires senha != "" && senha.length() >= 8;
    //@   requires endereco != "";
    //@   requires telefone != "";
    //@   requires cargo != "";
    //@   requires dataContratacao != null;
    //@   ensures nome2 == nome;
    //@   ensures email2 == email;
    //@   ensures senha2 == senha;
    //@   ensures endereco2 == endereco;
    //@   ensures telefone2 == telefone;
    public Funcionario(String nome, String email, String senha, String endereco, String telefone, String cargo, LocalDate dataContratacao) {
        super(nome, email, senha, endereco, telefone);
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

    /*@
      @ public normal_behavior
      @   requires cargo != null && !cargo.isEmpty();
      @   ensures this.cargo == cargo;
      @ also
      @ exceptional_behavior
      @   requires cargo == null || cargo.isEmpty();
      @   signals_only IllegalArgumentException;
      @*/
    public void setCargo(String cargo) {
        if (cargo == null || cargo.isEmpty()) {
            throw new IllegalArgumentException("Cargo do funcionário não pode ser vazio.");
        }
        this.cargo = cargo;
    }

    /*@
      @ public normal_behavior
      @   requires dataContratacao != null;
      @   ensures this.dataContratacao == dataContratacao;
      @ also
      @ exceptional_behavior
      @   requires dataContratacao == null;
      @   signals_only IllegalArgumentException;
      @*/
    public void setDataContratacao(LocalDate dataContratacao) {
        if (dataContratacao == null) {
            throw new IllegalArgumentException("Data de contratação do funcionário não pode ser vazia.");
        }
        this.dataContratacao = dataContratacao;
    }

    /*@
      @ public normal_behavior
      @   ensures \result == this.dataContratacao;
      @   pure
      @*/
    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    /*@
      @ public normal_behavior
      @   ensures \result == this.cargo;
      @   pure
      @*/
    public String getCargo() {
        return cargo;
    }


}
