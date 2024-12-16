package br.com.fatecmogidascruzes.model.entity;


public class Categoria implements IItemInventario {

    private int id;

    @Override
    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    private String nome;
    private String descricao;

    public Categoria(String nome, String descricao) {
        setNome(nome);
        setDescricao(descricao);
    }

    public void setId(int id) {
        try {
            if (id < 0) {
                throw new IllegalArgumentException("ID não pode ser negativo.");
            }
            this.id = id;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um ID válido.");
        }
    }

    public void setNome(String nome) {
        try {
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Nome da categoria não pode ser vazio.");
            }
            this.nome = nome;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um nome válido.");
        }
    }
    @Override
    public void setDescricao(String descricao) {
        try {
            if (descricao == null || descricao.isEmpty()) {
                throw new IllegalArgumentException("Descrição da categoria não pode ser vazio.");
            }
            this.descricao = descricao;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira uma descrição válida.");
        }
    }

    @Override
    public String toString() {
        return "\n Categoria {" +
                "\n  Id = " + id +
                "\n  Nome = " + nome +
                "\n  Descricao = " + descricao +
                "\n }\n";
    }

}