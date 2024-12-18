package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Categoria;
import br.com.fatecmogidascruzes.model.repository.CategoriaRepository;
import br.com.fatecmogidascruzes.service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService {

    //@ skipesc
    public void log(String message) {
        System.out.println(message);
    }

    /*@
      @ also requires categoria != null;
      @ also requires categoria.getNome() != null;
      @ also requires CategoriaRepository.findByName(categoria.getNome()) == null;
      @*/
    //@ skipesc
    public void adicionarCategoria(Categoria categoria) {
        CategoriaRepository.save(categoria);
        log("Categoria " + categoria.getNome() + " adicionada com sucesso!");
    }


    /*@
      @ also requires id >= 0;
      @*/
    public void excluirCategoria(int id) {
        if (id < 0) {
            log("ID não pode ser negativo");
        }
        try {
            CategoriaRepository.removerCategoria(id);
            log("Categoria removida com sucesso!");
        } catch (IllegalArgumentException e) {
            log(" Por favor, verifique o ID informado.");
        }
    }

    /*@
      @ also requires nome != null;
      @ also ensures (\result == null || (\result.getNome() != null && \result.getNome().equalsIgnoreCase(nome)));
      @*/
    //@ skipesc
    public Categoria buscarCategoriaPorNome(String nome) {
        Categoria categoria = CategoriaRepository.findByName(nome);
        if (categoria != null) {
            return categoria;
        } else {
            log("Categoria com nome " + nome + " não encontrada.");
            return null;
        }
    }
}
