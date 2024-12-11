package br.com.fatecmogidascruzes.model.entity;

public interface IItemInventario {

    /*@ ensures \result != null && !\result.isEmpty(); @*/
    /*@ pure @*/ String getDescricao();

    /*@ requires descricao != null && !descricao.isEmpty(); @*/
    /*@ ensures getDescricao().equals(descricao); @*/
    void setDescricao(String descricao);
}
