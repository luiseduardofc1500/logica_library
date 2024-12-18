package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Categoria;

public interface CategoriaService {

    /*@
      @ requires categoria != null;
      @ requires categoria.getNome() != null;
      @ requires categoriaRepository.findByName(categoria.getNome()) == null;
      @ assignable System.out.outputText, System.out.eol;
      @*/
    void adicionarCategoria(Categoria categoria);


    /*@
      @ requires id >= 0;
      @ assignable System.out.outputText, System.out.eol;
      @*/
    void excluirCategoria(int id);

    /*@
      @ requires nome != null;
      @ ensures (\result == null || (\result.getNome() != null && \result.getNome().equalsIgnoreCase(nome)));
      @ ensures (\forall int i; 0 <= i && i < categoriaRepository.findAllCategorias().size(); !categoriaRepository.findAllCategorias().get(i).getNome().equalsIgnoreCase(nome)) ==>
      @ \result == null;
      @ assignable System.out.outputText, System.out.eol;
      @*/
    Categoria buscarCategoriaPorNome(String nome);
}
