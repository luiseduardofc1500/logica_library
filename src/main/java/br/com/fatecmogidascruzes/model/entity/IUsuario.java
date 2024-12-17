package br.com.fatecmogidascruzes.model.entity;

public interface IUsuario {

    //@ model instance public String nome2;
    //@ model instance public String email2;
    //@ model instance public String senha2;
    //@ model instance public String endereco2;
    //@ model instance public String telefone2;


    //@ ensures \result == nome2;
    //@ pure
    String getNome();

    //@ requires nome2 != "";
    void setNome(String nome);

    //@ ensures \result == email2;
    //@ pure
    String getEmail();

    //@ requires email2 != "";
    void setEmail(String email);

    //@ ensures \result == senha2;
    //@ pure
    String getSenha();

    //@ requires senha2 != "" && senha2.length() >= 8;
    void setSenha(String senha);

    //@ ensures \result == endereco2;
    //@ pure
    String getEndereco();

    //@ requires endereco2 != "";
    void setEndereco(String endereco);

    //@ ensures \result == telefone2;
    //@ pure
    String getTelefone();

    //@ requires telefone2 != "";
    void setTelefone(String telefone);


}
