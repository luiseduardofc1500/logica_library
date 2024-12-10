package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Categoria;

public interface CategoriaService {

    void adicionarCategoria(Categoria categoria);
    void atualizarCategoria(long id, Categoria categoria);
    void excluirCategoria(int id);
    Categoria buscarCategoriaPorNome(String nome);
}
