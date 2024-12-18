package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Categoria;
import java.util.ArrayList;
import java.util.List;



public class CategoriaRepository {

    //@ spec_public
    private static final List<Categoria> categorias = new ArrayList<>();

    private static int ultimoId = 0;

    /*@
      @ requires categoria != null;
      @ requires categoria.getNome() != null;
      @ requires findByName(categoria.getNome()) == null;
      @*/
    public static void save(Categoria categoria) {
        //@ nullable
        Categoria categoriaExistente = findByName(categoria.getNome());
        if (categoriaExistente == null) {
            categorias.add(categoria);
        } else {
            throw new IllegalArgumentException("Cliente com o email já existe.");
        }
    }


    public /*@ pure @*/ static List<Categoria> findAllCategorias() {
        return categorias;
    }


    private static int findIndexPorId(int id) {
        int index = 0;
        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);
            if (categoria.getId() == id) {
                index = i;
                return index;
            }
        }
        return index;
    }

    /*@
      @ requires id >= 0;
      @ ensures (\result == null || (\result.getId() >= 0 && \result.getId()==(id)));
      @ nullable
      @*/
    public /*@ pure @*/ static Categoria findById(int id) {
        for (int j = 0; j < categorias.size(); j++) {
            Categoria categoria = categorias.get(j);
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }

    /*@
      @ requires nome != null;
      @ ensures (\result == null || (\result.getNome() != null && \result.getNome().equalsIgnoreCase(nome)));
      @ ensures (\forall int i; 0 <= i && i < categorias.size(); !categorias.get(i).getNome().equalsIgnoreCase(nome)) ==>
      @ \result == null;
      @ nullable
      @*/
    public /*@ pure @*/ static Categoria findByName(String nome) {
        //@ loop_invariant 0 <= j && j <= categorias.size();
        //@ loop_invariant (\forall int k; 0 <= k && k < j; !categorias.get(k).getNome().equalsIgnoreCase(nome));
        //@ decreasing categorias.size() - j;
        for (int j = 0; j < categorias.size(); j++) {
            //@ assume categorias.get(j) != null;
            Categoria categoria = categorias.get(j);
            if (categoria.getNome().equalsIgnoreCase(nome)) {
                return categoria;
            }
        }
        //@ assert (\forall int i; 0 <= i && i < categorias.size(); !categorias.get(i).getNome().equalsIgnoreCase(nome));
        return null;
    }

    //@ requires id >= 0;
    public static void removerCategoria(int id) {
        //@ nullable
        Categoria categoria = findById(id);
        if (categoria != null) {
            categorias.remove(categoria);
        } else
            throw new IllegalArgumentException("Categoria não encontrada.");
    }
}
