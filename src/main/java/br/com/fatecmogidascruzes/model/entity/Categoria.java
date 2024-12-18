package br.com.fatecmogidascruzes.model.entity;


public class Categoria implements IItemInventario {

    //@ spec_public
    private int id;

    //@ spec_public
    private String nome;

    //@ spec_public
    private static int count = 0;

    private String descricao; //@in descricao2

    //@ private represents descricao2 = this.descricao;

    //@ also ensures \result == descricao2;
    /*@ pure @*/
    @Override
    public String getDescricao() {
        return descricao;
    }

    //@ ensures \result == nome;
    /*@ pure @*/
    public String getNome() {
        return nome;
    }

    //@ ensures \result == id;
    /*@ pure @*/
    public int getId() {
        return id;
    }


    /*@ public normal_behavior
          @     requires nome != "";
          @     requires descricao != "";
          @     requires count < Integer.MAX_VALUE;
          @     assigns count;
          @     ensures this.nome == nome;
          @     ensures this.id == count;
          @     ensures descricao2 == descricao;
          @     ensures count == \old(count) + 1;
          @*/
    public Categoria(String nome, String descricao) {
        //@ assume count+1 < Integer.MAX_VALUE;
        count++;

        this.id = count;
        this.nome = nome;
        this.descricao = descricao;
    }

    //@ requires id >= 0;
    public void setId(int id) {
        if(id >= 0){
            this.id = id;
        }
    }

    //@ requires nome != null && !nome.isEmpty();
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
    //@ also requires descricao != null;
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
    /*
    @Override
    public String toString() {
        return "\n Categoria {" +
                "\n  Id = " + id +
                "\n  Nome = " + nome +
                "\n  Descricao = " + descricao +
                "\n }\n";
    }*/

}