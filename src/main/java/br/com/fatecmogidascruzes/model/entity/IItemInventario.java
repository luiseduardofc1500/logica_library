package br.com.fatecmogidascruzes.model.entity;

public interface IItemInventario {

    //@ model instance public String descricao2;


    //@ ensures \result == descricao2;
    /*@ pure @*/
    String getDescricao();

    //@ requires descricao != "";
    void setDescricao(String descricao);
}