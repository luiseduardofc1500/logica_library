package br.com.fatecmogidascruzes.validator;

public class LivroValidator {

    public static boolean validarIsbn10(String isbn10) {
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (10 - i) * Character.getNumericValue(isbn10.charAt(i));
        }

        soma = (11 - (soma % 11)) % 11;
        char ultimoDigito = (soma == 10) ? 'X' : Character.forDigit(soma, 10);
        return isbn10.charAt(9) == ultimoDigito;
    }

    public static boolean validarIsbn13(String isbn13) {
        int soma = 0;
        for (int i = 0; i < 12; i++) {
            soma += ((i % 2 == 0) ? 1 : 3) * Character.getNumericValue(isbn13.charAt(i));
        }

        soma = (10 - (soma % 10)) % 10;
        char ultimoDigito = Character.forDigit(soma, 10);
        return isbn13.charAt(12) == ultimoDigito;
    }
}
