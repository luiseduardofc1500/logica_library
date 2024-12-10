package br.com.fatecmogidascruzes.service;

import java.util.List;
import br.com.fatecmogidascruzes.model.entity.Livro;

public interface LivroService {
	
	void adicionarLivro(Livro livro);
	void atualizarLivro(long id, Livro livro);
    void excluirLivroPorId(long id);
    void excluirLivroPorIsbn10(String isbn10);
    void excluirLivroPorIsbn13(String isbn13);
    List<Livro> buscarLivro(int opcao, String valorBuscar);

}
