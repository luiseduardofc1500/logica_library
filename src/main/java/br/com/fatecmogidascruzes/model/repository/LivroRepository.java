package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LivroRepository {
	
	private static final List<Livro> livros = new ArrayList<>();
	private static long ultimoId = 0;

	public static void save(Livro livro) {
		livro.setId(++ultimoId);
		livros.add(livro);
	}

	public static void atualizarLivro(long id, Livro livro) {
		int index = findIndexPorId(id);
		if (index != -1) {
			livro.setId(id);
			livros.set(index, livro);
		} else {
			throw new IllegalArgumentException("Ocorreu algo de errado ao atualizar informações do livro, por favor verifique as informações e tente novamente");
		}
	}

	public static void removerLivro(Livro livro) {
		if (livro != null) {
			livros.remove(livro);
		} else 
			throw new IllegalArgumentException("Livro não encontrado.");
	}

	public static List<Livro> findAll() {
		return livros;
	}

	private static int findIndexPorId(long id) {
		return livros.stream()
				.filter(livro -> livro.getId() == id)
				.findFirst()
				.map(livros::indexOf)
				.orElse(-1);
	}

	public static Livro findById(long id) {
		return livros.stream()
				.filter(livro -> livro.getId() == id)
				.findFirst()
				.orElse(null);
	}
	
	public static Livro findByIsbn10(String isbn10) {
		return livros.stream()
				.filter(livro -> livro.getIsbn10().equals(isbn10))
				.findFirst()
				.orElse(null);
	}

	public static Livro findByIsbn13(String isbn13) {
		return livros.stream()
				.filter(livro -> livro.getIsbn13().equals(isbn13))
				.findFirst()
				.orElse(null);
	}
	//fiz afor
	public static Livro findByTituloLivro(String titulo) {
		return livros.stream()
				.filter(livro -> livro.getTitulo().toUpperCase().contains(titulo.toUpperCase()))
				.findFirst()
				.orElse(null);
	}

	public static List<Livro> findAllWhereExistEstoque() {
		return livros.stream()
				.filter(livro -> livro.getEstoque() > 0)
				.collect(Collectors.toList());
	}
	
	public static List<Livro> findByPreco(Double preco) {
		return livros.stream()
				.filter(livro -> livro.getPreco() == preco)
				.collect(Collectors.toList());
	}
	
	public static List<Livro> findByEstoque(Integer qtd) {
		return livros.stream()
				.filter(livro -> livro.getEstoque() == qtd)
				.collect(Collectors.toList());
	}
	
	public static List<Livro> findByTituloLista(String titulo) {
		return livros.stream()
				.filter(livro -> livro.getTitulo().toUpperCase().contains(titulo.toUpperCase()))
				.collect(Collectors.toList());
	}
	
	public static List<Livro> findByAutor(String autor) {
		return livros.stream()
				.filter(livro -> livro.getAutor().toUpperCase().contains(autor.toUpperCase()))
				.collect(Collectors.toList());
	}
	
	public static List<Livro> findByIdioma(String idioma) {
		return livros.stream()
				.filter(livro -> livro.getIdioma().toUpperCase().contains(idioma.toUpperCase()))
				.collect(Collectors.toList());
	}

	public static List<Livro> findByEditora(String editora) {
		return livros.stream()
				.filter(livro -> livro.getEditora().toUpperCase().contains(editora.toUpperCase()))
				.collect(Collectors.toList());
	}	

	public static List<Livro> findByCategoria(String categoria) {
		return livros.stream()
				.filter(livro -> livro.getCategoria().toUpperCase().contains(categoria.toUpperCase()))
				.collect(Collectors.toList());
	}
	
}