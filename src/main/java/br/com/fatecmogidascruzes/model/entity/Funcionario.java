package br.com.fatecmogidascruzes.model.entity;

import java.time.LocalDate;

public class Funcionario extends Usuario {

    private String cargo;

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public String getCargo() {
        return cargo;
    }

    private LocalDate dataContratacao;

    public Funcionario(String email, String nome, String senha, String endereco, String telefone, String cargo, LocalDate dataContratacao) {
        super(email, nome, senha, endereco, telefone);
        setCargo(cargo);
        setDataContratacao(dataContratacao);
    }

    public void setCargo(String cargo) {
        try {
            if (cargo == null || cargo.isEmpty()) {
                throw new IllegalArgumentException("Cargo do funcionário não pode ser vazio.");
            }
            this.cargo = cargo;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um cargo válido.");
        }      
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        try {
            if (dataContratacao == null) {
                throw new IllegalArgumentException("Data de contratação do funcionário não pode ser vazio.");
            }
            this.dataContratacao = dataContratacao;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira uma data de contratação para o funcionário.");
        }
    }

    @Override
    public String toString() {
        return "\n Funcionario {" +
                "\n  Id = " + getId() +
                "\n  Email = " + getEmail() +
                "\n  Nome = " + getNome() +
                "\n  Endereco = " + getEndereco() +
                "\n  Telefone = " + getTelefone() +
                "\n  Cargo = " + cargo +
                "\n  Data de Contratação = " + dataContratacao +
                "\n }\n";
    }
}