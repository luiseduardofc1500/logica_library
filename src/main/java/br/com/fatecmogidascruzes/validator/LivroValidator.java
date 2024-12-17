package br.com.fatecmogidascruzes.validator;

public class LivroValidator {


    /*@ public normal_behavior
    @     requires isbn10 != null && isbn10.length() == 10;
    @     ensures \result == (isbn10.charAt(9) ==
    @         Character.forDigit(
    @             (11 -
    @                 ((0) * Character.getNumericValue(isbn10.charAt(0)) +
    @                  (1) * Character.getNumericValue(isbn10.charAt(1)) +
    @                  (2) * Character.getNumericValue(isbn10.charAt(2)) +
    @                  (3) * Character.getNumericValue(isbn10.charAt(3)) +
    @                  (4) * Character.getNumericValue(isbn10.charAt(4)) +
    @                  (5) * Character.getNumericValue(isbn10.charAt(5)) +
    @                  (6) * Character.getNumericValue(isbn10.charAt(6)) +
    @                  (7) * Character.getNumericValue(isbn10.charAt(7)) +
    @                  (8) * Character.getNumericValue(isbn10.charAt(8)))
    @             % 11) % 11, 10));
    @     pure
    @*/
    public static boolean validarIsbn10(String isbn10) {
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (10 - i) * Character.getNumericValue(isbn10.charAt(i));
        }

        soma = (11 - (soma % 11)) % 11;
        char ultimoDigito = (soma == 10) ? 'X' : Character.forDigit(soma, 10);
        return isbn10.charAt(9) == ultimoDigito;
    }



    /*@ public normal_behavior
      @     requires isbn13 != null && isbn13.length() == 13;
      @     ensures \result == (isbn13.charAt(12) ==
      @         Character.forDigit(
      @             (10 -
      @                 ((0 % 2 == 0 ? 1 : 3) * Character.getNumericValue(isbn13.charAt(0)) +
      @                  (1 % 2 == 0 ? 1 : 3) * Character.getNumericValue(isbn13.charAt(1)) +
      @                  (2 % 2 == 0 ? 1 : 3) * Character.getNumericValue(isbn13.charAt(2)) +
      @                  (3 % 2 == 0 ? 1 : 3) * Character.getNumericValue(isbn13.charAt(3)) +
      @                  (4 % 2 == 0 ? 1 : 3) * Character.getNumericValue(isbn13.charAt(4)) +
      @                  (5 % 2 == 0 ? 1 : 3) * Character.getNumericValue(isbn13.charAt(5)) +
      @                  (6 % 2 == 0 ? 1 : 3) * Character.getNumericValue(isbn13.charAt(6)) +
      @                  (7 % 2 == 0 ? 1 : 3) * Character.getNumericValue(isbn13.charAt(7)) +
      @                  (8 % 2 == 0 ? 1 : 3) * Character.getNumericValue(isbn13.charAt(8)) +
      @                  (9 % 2 == 0 ? 1 : 3) * Character.getNumericValue(isbn13.charAt(9)) +
      @                  (10 % 2 == 0 ? 1 : 3) * Character.getNumericValue(isbn13.charAt(10)) +
      @                  (11 % 2 == 0 ? 1 : 3) * Character.getNumericValue(isbn13.charAt(11)))
      @             % 10) % 10, 10));
      @     pure
      @*/
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
