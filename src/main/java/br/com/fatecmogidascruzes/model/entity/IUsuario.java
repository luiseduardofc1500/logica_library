package br.com.fatecmogidascruzes.model.entity;

public interface IUsuario {
    // @ model instance public string nome;
    // @ model instance public string email;
    // @ model instance public string senha;
    // @ model instance public string endereco;
    // @ model instance public string telefone;

    /*@ ensures \result != null && !\result.isEmpty(); @*/
    /*@ pure @*/
    String getNome();

    /*@ requires nome != null && !nome.isEmpty(); @*/
    /*@ ensures getNome().equals(nome); @*/
    void setNome(String nome);

    /*@ ensures \result != null && !\result.isEmpty(); @*/
    /*@ pure @*/
    String getEmail();

    /*@ requires email != null && !email.isEmpty(); @*/
    /*@ ensures getEmail().equals(email); @*/
    void setEmail(String email);

    /*@ ensures \result != null && !\result.isEmpty(); @*/
    /*@ pure @*/
    String getSenha();

    /*@
      requires senha != null &&
               !senha.isEmpty() &&
               senha.length() >= 8 &&
               (\exists int i; 0 <= i < senha.length(); Character.isUpperCase(senha.charAt(i))) &&
               (\exists int i; 0 <= i < senha.length(); !Character.isLetterOrDigit(senha.charAt(i)));
      @ ensures getSenha().equals(senha);
    @*/
    void setSenha(String senha);

    /*@ ensures \result != null && !\result.isEmpty(); @*/
    /*@ pure @*/
    String getEndereco();

    /*@ requires endereco != null && !endereco.isEmpty(); @*/
    /*@ ensures getEndereco().equals(endereco); @*/
    void setEndereco(String endereco);

    /*@ ensures \result != null && !\result.isEmpty(); @*/
    /*@ pure @*/
    String getTelefone();

    /*@ requires telefone != null && !telefone.isEmpty(); @*/
    /*@ ensures getTelefone().equals(telefone); @*/
    void setTelefone(String telefone);
}
