package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Categoria;

public interface CategoriaService {

    /*@ public normal_behavior
      @     requires categoria != null;
      @     ensures categoria.getId() > 0;
      @     ensures categoria.getNome() != null && !categoria.getNome().isEmpty();
      @     ensures categoria.getDescricao() != null && !categoria.getDescricao().isEmpty();
      @*/
    void adicionarCategoria(Categoria categoria);

    /*@ public normal_behavior
      @     requires id > 0;
      @     requires categoria != null;
      @     requires categoria.getId() == id;
      @     ensures categoria.getNome() != null && !categoria.getNome().isEmpty();
      @     ensures categoria.getDescricao() != null && !categoria.getDescricao().isEmpty();
      @*/
    void atualizarCategoria(int id, Categoria categoria);

    /*@ public normal_behavior
      @     requires id > 0;
      @*/
    void excluirCategoria(int id);

    /*@ public normal_behavior
      @     requires nome != null && !nome.isEmpty();
      @     ensures \result != null;
      @     ensures \result.getNome().equals(nome);
      @*/
    Categoria buscarCategoriaPorNome(String nome);
}
