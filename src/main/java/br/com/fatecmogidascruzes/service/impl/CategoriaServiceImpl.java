package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Categoria;
import br.com.fatecmogidascruzes.model.repository.CategoriaRepository;
import br.com.fatecmogidascruzes.service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService {
    //@ spec_public
    private CategoriaRepository categoriaRepository;


    /*@
      @ also requires categoria != null;
      @ also requires categoria.getNome() != null;
      @ also requires categoriaRepository.findByName(categoria.getNome()) == null;
      @ also assignable System.out.outputText, System.out.eol;
      @*/
    public void adicionarCategoria(Categoria categoria) {
        CategoriaRepository.save(categoria);
        System.out.println("Categoria " + categoria.getNome() + " adicionada com sucesso!");
    }


    /*@
      @ also requires id >= 0;
      @ also assignable System.out.outputText, System.out.eol;
      @*/
    public void excluirCategoria(int id) {
        try {
            CategoriaRepository.removerCategoria(id);
            System.out.println("Categoria removida com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor, verifique o ID informado.");
        }
    }

    /*@
      @ also requires nome != null;
      @ also ensures (\result == null || (\result.getNome() != null && \result.getNome().equalsIgnoreCase(nome)));
      @ also ensures (\forall int i; 0 <= i && i < categoriaRepository.findAllCategorias().size(); !categoriaRepository.findAllCategorias().get(i).getNome().equalsIgnoreCase(nome)) ==>
      @ \result == null;
      @ also assignable System.out.outputText, System.out.eol;
      @*/
    public Categoria buscarCategoriaPorNome(String nome) {
        Categoria categoria = CategoriaRepository.findByName(nome);
        if (categoria != null) {
            return categoria;
        } else {
            System.out.println("Categoria com nome " + nome + " não encontrada.");
            return null;
        }
    }
}
