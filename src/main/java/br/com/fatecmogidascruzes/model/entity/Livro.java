package br.com.fatecmogidascruzes.model.entity;

import br.com.fatecmogidascruzes.validator.LivroValidator;

import java.time.LocalDate;

public class Livro implements IItemInventario {

    private int id;
    private String isbn10;
    private String isbn13;
    private String titulo;
    private String idioma;
    private String autor;
    private String descricao;

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getEditora() {
        return editora;
    }

    public int getEstoque() {
        return estoque;
    }

    public String getAutor() {
        return autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public int getId() {
        return id;
    }

    private int estoque;
    private String editora;
    private int numeroDePaginas;
    private LocalDate dataDePublicacao;
    private double preco;
    private String categoria;

    public Livro(String isbn10, String isbn13, String titulo, String idioma, String autor, int estoque, String editora, int numeroDePaginas, LocalDate dataDePublicacao, double preco, String categoria) { 
        setIsbn10(isbn10);
        setIsbn13(isbn13);
        setTitulo(titulo);
        setIdioma(idioma);
        setAutor(autor);
        setEstoque(estoque);
        setEditora(editora);
        setNumeroDePaginas(numeroDePaginas);
        setDataDePublicacao(dataDePublicacao);
        setPreco(preco);
        setCategoria(categoria);
    }

    public void setId(int id) {
        try {
            if (id < 0) {
                throw new IllegalArgumentException("ID não pode ser negativo.");
            }
            this.id = id;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um ID válido.");
        }
    }

    public void setIsbn10(String isbn10) {
        try {
            if (isbn10 != null && !isbn10.isEmpty()) {
                if (isbn10.length() != 10 || !isbn10.matches("[0-9]{9}[0-9X]")) {
                    throw new IllegalArgumentException("ISBN-10 inválido.");
                }
                if (!LivroValidator.validarIsbn10(isbn10)){
                    throw new IllegalArgumentException("ISBN-10 inválido.");
                }
            }
            this.isbn10 = isbn10;
            
        } catch (IllegalArgumentException e) {
            System.out.println( e.getMessage() + " Por favor insira um ISBN-10 válido.");
        }
    }

    public void setIsbn13(String isbn13) {
        try {
            if (isbn13 != null && !isbn13.isEmpty()) {
                if (isbn13.length() != 13 || !isbn13.matches("[0-9]{13}")) {
                    throw new IllegalArgumentException("ISBN-13 inválido.");
                }
                if (!LivroValidator.validarIsbn13(isbn13)){
                    throw new IllegalArgumentException("ISBN-13 inválido.");
                }            
            } 
            this.isbn13 = isbn13;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um ISBN-13 válido.");
        }
    }

    public void setTitulo(String titulo) {
        try {
            if (titulo == null || titulo.isEmpty()) {
                throw new IllegalArgumentException("Título não pode ser vazio.");
            }
            this.titulo = titulo;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um título válido.");
        }
    }

    public void setIdioma(String idioma) {
        try {
            if (idioma == null || idioma.isEmpty()) {
                throw new IllegalArgumentException("Idioma não pode ser vazio.");
            }
            this.idioma = idioma;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um idioma válido.");
        }
    }

    public void setAutor(String autor) {
        try {
            if (autor == null || autor.isEmpty()) {
                throw new IllegalArgumentException("Autor não pode ser vazio.");
            }
            this.autor = autor;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um autor válido.");
        }
    }

    public void setEstoque(int estoque) {
        try {
            if (estoque < 0) {
                throw new IllegalArgumentException("Estoque não pode ser negativo.");
            }
            this.estoque = estoque;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um estoque válido.");
        }
    }

    public void setEditora(String editora) {
        try {
            if (editora == null || editora.isEmpty()) {
                throw new IllegalArgumentException("Editora não pode ser vazio.");
            }
            this.editora = editora;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira uma editora válida.");
        }
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        try {
            if (numeroDePaginas < 1) {
                throw new IllegalArgumentException("Livro deve ter pelo menos uma página.");
            }
            this.numeroDePaginas = numeroDePaginas;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um número de páginas válido.");
        }
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        try {
            if (dataDePublicacao == null) {
                throw new IllegalArgumentException("Data de publicação não pode ser vazio.");
            }
            this.dataDePublicacao = dataDePublicacao;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira uma data de publicação válida.");
        }
    }

    public void setPreco(double preco) {
        try {
            if (preco < 0) {
                throw new IllegalArgumentException("Preço não pode ser negativo.");
            }
            this.preco = preco;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um preço válido.");
        }
    }

    public void setCategoria(String categoria) {
        try {
            if (categoria == null || categoria.isEmpty()) {
                throw new IllegalArgumentException("Categoria não pode ser vazio.");
            }
            this.categoria = categoria;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira uma categoria válida.");
        }
    }

    @Override
    public String toString() {
        return "\n Livro {" +
            "\n  id = " + id +
            "\n  isbn-10 = " + isbn10 +
            "\n  isbn-13 = " + isbn13 +
            "\n  titulo = " + titulo  +
            "\n  idioma = " + idioma +
            "\n  autor = " + autor +
            "\n  estoque = " + estoque +
            "\n  editora = " + editora +
            "\n  numeroDePaginas = " + numeroDePaginas +
            "\n  dataDePublicacao = " + dataDePublicacao +
            "\n  preço = " + preco +
            "\n  categoria = " + categoria +
            "\n }\n";
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia.");
        }
        this.descricao = descricao;
    }
}