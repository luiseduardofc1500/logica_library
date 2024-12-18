package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LivroRepository {

	//@spec_public
	private static final List<Livro> livros = new ArrayList<>();
	private static int ultimoId = 0;
	//@ skipesc
	public static void save(Livro livro) {
		livro.setId((int) ++ultimoId);
		livros.add(livro);
		Livro livroExistente = livro;
		if (livroExistente == null) {
			livros.add(livro);
		} else {
			throw new IllegalArgumentException("Cliente com o email já existe.");
		}
	}
	//@ skipesc
	public static void removerLivro(Livro livro) {
		if (livro != null) {
			livros.remove(livro);
		} else 
			throw new IllegalArgumentException("Livro não encontrado.");
	}
	//@ skipesc
	public static List<Livro> findAll() {
		return livros;
	}


	//@ skipesc
	public static Livro findById(int id) {
		for(int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			if(livro.getId() == id){
				return livro;
			}
		}
        return null;
    }


	//@ skipesc
	public static Livro findByIsbn10(String isbn10) {
		for(int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			if(livro.getIsbn10().equals(isbn10)){
				return livro;
			}
		}
		return null;
	}
	//@ skipesc
	public static Livro findByIsbn13(String isbn13) {
		for(int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			if(livro.getIsbn13().equals(isbn13)){
				return livro;
			}
		}
		return null;
	}
	//@ skipesc
	public static Livro findByTituloLivro(String titulo) {
		for(int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			if(livro.getTitulo().equalsIgnoreCase(titulo)){
				return livro;
			}
		}
		return null;
	}
	//@ skipesc
	public static List<Livro> findAllWhereExistEstoque() {
        List<Livro> allLivros = new ArrayList<>(livros);
		return allLivros;
	}
	//@ skipesc
	public static List<Livro> findByPreco(Double preco) {
		List<Livro> allLivros = new ArrayList<>();
		for(int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			if(livro.getPreco() == preco){
				allLivros.add(livro);
			}
		}
		return allLivros;
	}
	//@ skipesc
	public static List<Livro> findByEstoque(Integer qtd) {
		List<Livro> allLivros = new ArrayList<>();
		for(int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			if(livro.getEstoque() == qtd){
				allLivros.add(livro);
			}
		}
		return allLivros;
	}
	//@ skipesc
	public static List<Livro> findByTituloLista(String titulo) {
		List<Livro> allLivros = new ArrayList<>();
		for(int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			if(livro.getTitulo().equalsIgnoreCase(titulo)){
				allLivros.add(livro);
			}
		}
		return allLivros;
	}
	//@ skipesc
	public static List<Livro> findByAutor(String autor) {
		List<Livro> allLivros = new ArrayList<>();
		for(int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			if(livro.getAutor().equalsIgnoreCase(autor)){
				allLivros.add(livro);
			}
		}
		return allLivros;
	}
	//@ skipesc
	public static List<Livro> findByIdioma(String idioma) {
		List<Livro> allLivros = new ArrayList<>();
		for(int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			if(livro.getIdioma().equalsIgnoreCase(idioma)){
				allLivros.add(livro);
			}
		}
		return allLivros;
	}
	//@ skipesc
	public static List<Livro> findByEditora(String editora) {
		List<Livro> allLivros = new ArrayList<>();
		for(int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			if(livro.getEditora().equalsIgnoreCase(editora)){
				allLivros.add(livro);
			}
		}
		return allLivros;

	}
	//@ skipesc
	public static List<Livro> findByCategoria(String categoria) {
		List<Livro> allLivros = new ArrayList<>();
		for(int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			if(livro.getCategoria().equalsIgnoreCase(categoria)){
				allLivros.add(livro);
			}
		}
		return allLivros;
	}
	
}