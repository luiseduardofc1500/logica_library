package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Categoria;
import java.util.ArrayList;
import java.util.List;



public class CategoriaRepository {

    /*@
      @ public invariant categorias != null;
      @ public invariant (\forall int i; 0 <= i && i < categorias.size(); categorias.get(i) != null);
      @*/
    /*@ spec_public @*/ private static final List<Categoria> categorias = new ArrayList<>();


    private static int ultimoId = 0;

    /*@
      @ requires categoria != null;
      @ requires categoria.getNome() != null;
      @ requires findByName(categoria.getNome()) == null;
      @ ensures categorias.contains(categoria);
      @ also
      @ signals (IllegalArgumentException e) findByName(categoria.getNome()) != null;
      @*/
    public static void save(Categoria categoria) {
        Categoria categoriaExistente = findByName(categoria.getNome());
        if (categoriaExistente == null) {
            categorias.add(categoria);
        } else {
            throw new IllegalArgumentException("Cliente com o email já existe.");
        }
    }

    /*@
      @ requires id >= 0;
      @ requires categoria != null;
      @ requires findById(id) != null;
      @ ensures (\forall Categoria c; c != findById(id) ==> \old(categorias).contains(c) ==> categorias.contains(c));
      @ ensures findById(id).getNome().equals(categoria.getNome());
      @ ensures findById(id).getDescricao().equals(categoria.getDescricao());
      @ ensures findById(id).getId()==(categoria.getId());
      @ also
      @ signals (IllegalArgumentException e) findById(id) == null;
      @*/
    public static void atualizarCategoria(int id, Categoria categoria) {

        Categoria categoriaExistente = findById(id);
        if(categoriaExistente != null) {
            categoriaExistente.setNome(categoria.getNome());
            categoriaExistente.setDescricao(categoria.getDescricao());
            categoriaExistente.setId(id);
        } else {
            throw new IllegalArgumentException("Categoria com id não encontrada");
        }
    }


    public static List<Categoria> findAllCategorias() {
        return categorias;
    }


    private static int findIndexPorId(int id) {
        return categorias.stream()
                .filter(categoria -> categoria.getId() == id)
                .findFirst()
                .map(categorias::indexOf)
                .orElse(-1);
    }

    /*@
      @ requires id >= 0;
      @ ensures (\exists Categoria c; categorias.contains(c) && c.getId()==(id); \result == c)
      @   || \result == null;
      @*/
    public /*@ pure @*/ static Categoria findById(int id) {
        return categorias.stream()
                .filter(categoria -> categoria.getId() == id)
                .findFirst().orElse(null);
    }

    /*@
      @ requires nome != null;
      @ ensures (\exists Categoria c; categorias.contains(c) && c.getNome().equalsIgnoreCase(nome); \result == c)
      @   || \result == null;
      @*/
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
