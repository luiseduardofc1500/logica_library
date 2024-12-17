package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Categoria;
import java.util.ArrayList;
import java.util.List;



public class CategoriaRepository {
    //@ public invariant categorias != null && categorias.size() >= 0;

    //@ spec_public
    private static final List<Categoria> categorias = new ArrayList<>();

    //@ spec_public
    private static int ultimoId = 0;

    //@ requires ultimoId >= 0;
    public static void save(Categoria categoria) {
        categoria.setId(++ultimoId);
        categorias.add(categoria);
    }

    /*@
      @ public normal_behavior
      @   requires id >= 0;
      @   requires categoria != null;
      @   requires categoria.getNome() != null && !categoria.getNome().isEmpty();
      @   requires findById(id) != null;
      @   ensures categorias.contains(categoria);
      @ also
      @ signals (IllegalArgumentException e)
      @   id < 0 || categoria == null || categoria.getNome() == null || categoria.getNome().isEmpty()
      @   || findById(id) == null || !(0 <= categorias.indexOf(findById(id)) && categorias.indexOf(findById(id)) < categorias.size());
      @*/
    public static void atualizarCategoria(int id, Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("A categoria não pode ser nula.");
        }
        if (categoria.getNome() == null || categoria.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da categoria não pode ser vazio.");
        }
        if (id < 0) {
            throw new IllegalArgumentException("ID não pode ser negativo.");
        }

        Categoria existente = findById(id);
        if (existente == null) {
            throw new IllegalArgumentException("Categoria não encontrada para o ID fornecido.");
        }

        int index = categorias.indexOf(existente);
        if (index >= 0 && index < categorias.size()) { // Garantia da pré-condição
            categoria.setId(id);
            categorias.set(index, categoria);
        } else {
            throw new IllegalArgumentException("Índice inválido. Não foi possível atualizar a categoria.");
        }

    }

    public static List<Categoria> findAllCategorias() {
        return categorias;
    }

    private /*@ pure @*/ static int findIndexPorId(int id) {
        return categorias.stream()
                .filter(categoria -> categoria.getId() == id)
                .findFirst()
                .map(categorias::indexOf)
                .orElse(-1);
    }

    public /*@ pure @*/ static Categoria findById(int id) {
        return categorias.stream()
                .filter(categoria -> categoria.getId() == id)
                .findFirst().orElse(null);
    }

    public /*@ pure @*/ static Categoria findByName(String nome) {
        return categorias.stream()
                .filter(categoria -> categoria.getNome().toUpperCase().contains(nome.toUpperCase()))
                .findFirst()
                .orElse(null);
    }

    public static void removerCategoria(int id) {
        Categoria categoria = findById(id);
        if (categoria != null) {
            categorias.remove(categoria);
        } else
            throw new IllegalArgumentException("Categoria não encontrada.");
    }
}
