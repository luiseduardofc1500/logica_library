package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Categoria;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepository {

    private static final List<Categoria> categorias = new ArrayList<>();
    private static long ultimoId = 0;

    public static void save(Categoria categoria) {
        categoria.setId(++ultimoId);
        categorias.add(categoria);
    }

    public static void atualizarCategoria(long id, Categoria categoria) {
        int index = findIndexPorId(id);
        if (index != -1) {
            categoria.setId(id);
            categorias.set(index, categoria);
        } else
            throw new IllegalArgumentException("Ocorreu algo de errado ao atualizar informações da categoria. Por favor, informe um ID Valido e tente novamente.");
    }

    public static void removerCategoria(int id) {
        Categoria categoria = findById(id);
        if (categoria != null) {
            categorias.remove(categoria);
        } else
            throw new IllegalArgumentException("Categoria não encontrada.");
    }

    public static List<Categoria> findAllCategorias() {
        return categorias;
    }

    private static int findIndexPorId(long id) {
        return categorias.stream()
                .filter(categoria -> categoria.getId() == id)
                .findFirst()
                .map(categorias::indexOf)
                .orElse(-1);
    }

    public static Categoria findById(long id) {
        return categorias.stream()
                .filter(categoria -> categoria.getId() == id)
                .findFirst().orElse(null);
    }

    public static Categoria findByName(String nome) {
        return categorias.stream()
                .filter(categoria -> categoria.getNome().toUpperCase().contains(nome.toUpperCase()))
                .findFirst()
                .orElse(null);
    }
}
