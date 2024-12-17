package br.com.fatecmogidascruzes.model.entity;


public class Categoria implements IItemInventario {

    //@ spec_public
    private String nome;

    //@ spec_public
    private long id;

    //@ spec_public
    private static int count = 0;

    private String descricao;//@ in descricao2;

    //@ private represents descricao2 = this.descricao;


    //@ ensures \result == nome;
    public String getNome() {
        return nome;
    }

    //@ ensures \result == id;
    public long getId() {
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

        this.nome = nome;
        this.id = count;
        this.descricao = descricao;

    }

    //@ requires id >= 0;
    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        }
    }

    //@ requires nome != "";
    public void setNome(String nome) {
        if(nome != ""){
            this.nome = nome;
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





public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao != "") {
            this.descricao = descricao;
        }
    }

}