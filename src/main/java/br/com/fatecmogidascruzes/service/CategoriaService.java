package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Categoria;
import br.com.fatecmogidascruzes.model.repository.CategoriaRepository;

public interface CategoriaService {

    void log(String message);

    /*@
      @ requires categoria != null;
      @ requires categoria.getNome() != null;
      @ requires CategoriaRepository.findByName(categoria.getNome()) == null;
      @*/
    void adicionarCategoria(Categoria categoria);

    /*@
      @ requires id >= 0;
      @*/
    void excluirCategoria(int id);


    /*@
      @ requires nome != null;
      @ ensures (\result == null || (\result.getNome() != null && \result.getNome().equalsIgnoreCase(nome)));
      @*/
    Categoria buscarCategoriaPorNome(String nome);


}
