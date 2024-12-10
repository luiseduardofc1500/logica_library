package br.com.fatecmogidascruzes.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.fatecmogidascruzes.model.entity.Livro;
import br.com.fatecmogidascruzes.model.repository.LivroRepository;
import br.com.fatecmogidascruzes.service.LivroService;

public class LivroServiceImpl implements LivroService {

    @Override
    public void adicionarLivro(Livro livro) {
        LivroRepository.save(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    @Override
    public void atualizarLivro(long id, Livro livro) {
        try {
            LivroRepository.atualizarLivro(id, livro);
            System.out.println("Livro " + livro.getTitulo() + " atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void excluirLivroPorId(long id) {
        try {
            Livro livro = LivroRepository.findById(id);
            LivroRepository.removerLivro(livro);
            System.out.println("Livro removido com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor, verifique o ID informado.");
        }
    }

    @Override
    public void excluirLivroPorIsbn10(String isbn10) {
        try {
            Livro livro = LivroRepository.findByIsbn10(isbn10);
            LivroRepository.removerLivro(livro);
            System.out.println("Livro removido com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor, verifique o ISBN10 informado.");
        }
    }

    @Override
    public void excluirLivroPorIsbn13(String isbn13) {
        try {
            Livro livro = LivroRepository.findByIsbn13(isbn13);
            LivroRepository.removerLivro(livro);
            System.out.println("Livro removido com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()  + " Por favor, verifique o ISBN13 informado.");
        }
    }

    public Livro comprarByTitulo(String titulo) {
        return LivroRepository.findByTituloLivro(titulo);
    }

	@Override
	public List<Livro> buscarLivro(int opcao, String valorBuscar) {	
	    List<Livro> livrosEncontrados = new ArrayList<>();

		switch(opcao){
			case 1:
				livrosEncontrados = LivroRepository.findAllWhereExistEstoque();
				break;
			case 2:
				livrosEncontrados.add(LivroRepository.findById(Long.parseLong(valorBuscar)));
				break;
			case 3:
				livrosEncontrados = LivroRepository.findByTituloLista(valorBuscar);
				break;
			case 4:
				livrosEncontrados = LivroRepository.findByAutor(valorBuscar);
				break;			
			case 5:
				livrosEncontrados = LivroRepository.findByIdioma(valorBuscar);
				break;
			case 6:
				livrosEncontrados = LivroRepository.findByEditora(valorBuscar);
				break;
			case 7:
				livrosEncontrados = LivroRepository.findByCategoria(valorBuscar);
				break;
			case 8:
				livrosEncontrados = LivroRepository.findByPreco(Double.parseDouble(valorBuscar));
				break;
			case 9:
				livrosEncontrados = LivroRepository.findByEstoque(Integer.parseInt(valorBuscar));
				break;
			default:
				System.out.println("Opção invalida.");
				break;
		}
		
	    if (livrosEncontrados == null || livrosEncontrados.isEmpty()) {
			System.out.println("Livro não encontrado.");
	    }
	    
		return livrosEncontrados;
	}
}